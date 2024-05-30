package com.boj.guidance.controller;

import com.boj.guidance.dto.ProblemDto.ProblemResponseDto;
import com.boj.guidance.dto.ProblemDto.ProblemsResponseDto;
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
    @GetMapping("/id")
    public ApiResponse<ProblemResponseDto> getProblemsByAlgorithmName(@RequestParam Integer problemId) {
        return ApiResponse.success(ResponseCode.ALGORITHM_NAME_SEARCH_SUCCESS.getMessage(), problemService.searchProblemById(problemId));
    }

    /**
     * 알고리즘 이름으로 검색
     */
    @GetMapping("/algorithm")
    public ApiResponse<ProblemsResponseDto> getProblemsByAlgorithmName(@RequestParam String name) {
        return ApiResponse.success(ResponseCode.ALGORITHM_NAME_SEARCH_SUCCESS.getMessage(), problemService.searchAllProblemByAlgorithm(name));
    }

    /**
     * 램덤으로 문제 추출
     * @사용자 ID 입력하여 맞춤 데이터를 반환하도록 변경 예정
     */
    // @RequestParam Integer memberId
    @GetMapping("/recommend")
    public ApiResponse<ProblemsResponseDto> getProblemsByRecommend() {
        return ApiResponse.success(ResponseCode.PROBLEM_RECOMMEND_SUCCESS.getMessage(), problemService.returnRandomProblems());
    }

}