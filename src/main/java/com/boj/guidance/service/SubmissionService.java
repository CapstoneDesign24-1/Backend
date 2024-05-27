// src/main/java/com/boj/guidance/service/SubmissionService.java
package com.boj.guidance.service;

import com.boj.guidance.domain.OpenAIResponse;
import com.boj.guidance.domain.Submission;
import com.boj.guidance.dto.SubmissionDto.SubmissionReceiveRequestDto;
import com.boj.guidance.repository.OpenAIResponseRepository;
import com.boj.guidance.repository.SubmissionRepository;
import com.boj.guidance.util.OpenAIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;

    private final OpenAIResponseRepository openAIResponseRepository;

    private final OpenAIClient openAIClient;

    public Submission saveSubmission(SubmissionReceiveRequestDto dto) {
        // Submission 객체를 데이터베이스에 저장
        Submission savedSubmission = submissionRepository.save(dto.toEntity());

        // OpenAI API 호출 및 응답 저장
        try {
            String gptResponse = openAIClient.getGPTResponse(savedSubmission.getCodeContent());
            // OpenAI 응답을 데이터베이스에 저장
            OpenAIResponse openAIResponse = new OpenAIResponse(savedSubmission.getSubmitId(), gptResponse);
            openAIResponseRepository.save(openAIResponse);
            System.out.println("GPT Response: " + gptResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savedSubmission;
    }
}
