package com.boj.guidance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private String handle;              // 사용자명
    private String bio;                 // 자기소개
    private Long solved_count;           // 푼 문제 수
    private Long tier;                  // 티어 (1-31)
    private Long rating;                // 레이팅
    private Long rating_by_problems_sum;   // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long rating_by_solved_count;   // 푼 문제 수로 계산한 레이팅

    @Builder
    public MemberResponseDto(
            String handle,
            String bio,
            Long solved_count,
            Long tier,
            Long rating,
            Long rating_by_problems_sum,
            Long rating_by_solved_count
    ) {
        this.handle = handle;
        this.bio = bio;
        this.solved_count = solved_count;
        this.tier = tier;
        this.rating = rating;
        this.rating_by_problems_sum = rating_by_problems_sum;
        this.rating_by_solved_count = rating_by_solved_count;
    }
}
