package com.boj.guidance.dto.ProblemDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProblemRecommendationRequestDto {
    private List<Integer> recommends;
}
