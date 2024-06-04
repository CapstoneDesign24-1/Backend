package com.boj.guidance.dto.MemberDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberAuthRequestDto {
    private String handle;               // 사용자명
    private String bio;                  // 자기소개
    private Long solvedCount;            // 푼 문제 수
    private Long tier;                   // 티어 (1-31)
    private Long rating;                 // 레이팅
    private Long ratingByProblemsSum;    // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long ratingBySolvedCount;    // 푼 문제 수로 계산한 레이팅
}
