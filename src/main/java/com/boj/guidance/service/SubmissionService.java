package com.boj.guidance.service;

import com.boj.guidance.domain.CodeAnalysis;
import com.boj.guidance.dto.SubmissionDto.SubmissionReceiveRequestDto;
import org.springframework.transaction.annotation.Transactional;

public interface SubmissionService {
    @Transactional
    CodeAnalysis saveSubmission(SubmissionReceiveRequestDto dto);
}
