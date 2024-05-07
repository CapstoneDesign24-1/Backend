package com.boj.guidance.controller;

import com.boj.guidance.dto.ProblemDto.ProblemResponseDto;
import com.boj.guidance.service.ProblemService;
import com.boj.guidance.util.api.ApiResponse;
import com.boj.guidance.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;

    /**
     * 문제 id로 검색
     */
    @GetMapping("/id")
    public ApiResponse<ProblemResponseDto> getProblemsByAlgorithmName(@RequestParam Integer id) {
        return ApiResponse.success(ResponseCode.ALGORITHM_NAME_SEARCH_SUCCESS.getMessage(), problemService.searchProblemById(id));
    }

    /**
     * 알고리즘 이름으로 검색
     */
    @GetMapping("/algorithm")
    public ApiResponse<List<ProblemResponseDto>> getProblemsByAlgorithmName(@RequestParam String name) {
        return ApiResponse.success(ResponseCode.ALGORITHM_NAME_SEARCH_SUCCESS.getMessage(), problemService.searchAllProblemByAlgorithm(name));
    }

}
