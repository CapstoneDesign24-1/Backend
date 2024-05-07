package com.boj.guidance.controller;

import com.boj.guidance.dto.ProblemDto.ProblemResponseDto;
import com.boj.guidance.service.ProblemService;
import com.boj.guidance.util.api.ApiResponse;
import com.boj.guidance.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;

    /**
     * 문제 id로 검색
     */
    @GetMapping("/algorithm/search")
    public ApiResponse<ProblemResponseDto> getProblemsByAlgorithmName(@RequestParam Integer problemId) {
        return ApiResponse.success(ResponseCode.ALGORITHM_NAME_SEARCH_SUCCESS.getMessage(), problemService.searchProblemById(problemId));
    }

}
