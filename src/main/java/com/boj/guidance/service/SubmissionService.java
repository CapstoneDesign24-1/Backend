package com.boj.guidance.service;

import com.boj.guidance.domain.OpenAIResponse;
import com.boj.guidance.domain.Submission;
import com.boj.guidance.dto.SubmissionDto.SubmissionReceiveRequestDto;
import com.boj.guidance.repository.OpenAIResponseRepository;
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
    private final OpenAIResponseRepository openAIResponseRepository;
    private final OpenAIClient openAIClient;
    private final ObjectMapper objectMapper;

    public Submission saveSubmission(SubmissionReceiveRequestDto dto) {
        // Submission 객체를 데이터베이스에 저장
        Submission savedSubmission = submissionRepository.save(dto.toEntity());

        // OpenAI API 호출 및 응답 저장
        try {
            String gptResponse = openAIClient.getGPTResponse(savedSubmission.getCodeContent());

            // JSON 파싱을 통해 "content" 부분만 추출
            JsonNode root = objectMapper.readTree(gptResponse);
            String content = root.path("choices").get(0).path("message").path("content").asText();

            // OpenAI 응답을 데이터베이스에 저장
            OpenAIResponse openAIResponse = OpenAIResponse.builder()
                    .response(content)
                    .submitId(savedSubmission.getSubmitId())
                    .build();
            openAIResponseRepository.save(openAIResponse);

            log.info("GPT Response: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savedSubmission;
    }
}
