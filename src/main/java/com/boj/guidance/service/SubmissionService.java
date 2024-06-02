package com.boj.guidance.service;

import com.boj.guidance.domain.CodeAnalysis;
import com.boj.guidance.domain.Submission;
import com.boj.guidance.dto.SubmissionDto.SubmissionReceiveRequestDto;
import com.boj.guidance.repository.CodeAnalysisRepository;
import com.boj.guidance.repository.SubmissionRepository;
import com.boj.guidance.util.OpenAIClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final CodeAnalysisRepository codeAnalysisRepository;
    private final OpenAIClient openAIClient;
    private final ObjectMapper objectMapper;

    public Submission saveSubmission(SubmissionReceiveRequestDto dto) {
        // Submission 객체를 데이터베이스에 저장
        Submission savedSubmission = submissionRepository.save(dto.toEntity());

        // OpenAI API 호출 및 응답 저장
        try {
            String prompt = "다음 코드를 분석하고 다음 형식으로 피드백을 제공해주세요:\n" +
                    "## 출력 형식 \n" +
                    "{\n" +
                    "\"time\" : \"해당 알고리즘의 시간 복잡도는 O() 입니다. 시간 복잡도에 대한 상세한 설명\",\n" +
                    "\"memory\" : \"해당 알고리즘의 공간 복잡도는 O() 입니다. 공간 복잡도에 대한 상세한 설명\",\n" +
                    "\"suggest\" : \"개선 방안에 대한 상세한 피드백\"\n" +
                    "}\n\n" +
                    "코드:\n" + savedSubmission.getCodeContent();

            String gptResponse = openAIClient.getGPTResponse(prompt);

            // JSON 파싱을 통해 "content" 부분만 추출
            JsonNode root = objectMapper.readTree(gptResponse);
            String content = root.path("choices").get(0).path("message").path("content").asText();

            // OpenAI 응답을 데이터베이스에 저장
            CodeAnalysis codeAnalysis = CodeAnalysis.builder()
                    .id(savedSubmission.getSubmitId()) // submitId를 id로 설정
                    .submitId(savedSubmission.getSubmitId())
                    .userName(savedSubmission.getUserName())
                    .response(content)
                    .codeContent(savedSubmission.getCodeContent())
                    .problemId(savedSubmission.getProblemId())
                    .problemTitle(savedSubmission.getProblemTitle())
                    .result(savedSubmission.getResult())
                    .build();
            codeAnalysisRepository.save(codeAnalysis);

            log.info("GPT Response: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savedSubmission;
    }
}
