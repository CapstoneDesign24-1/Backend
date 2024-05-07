package com.boj.guidance.service;

import com.boj.guidance.dto.ProblemDto.ProblemResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface ProblemService {

    @Transactional(readOnly = true)
    ProblemResponseDto searchProblemById(Integer problemId);

}
