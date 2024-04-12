package com.boj.guidance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberJoinRequestDto {
    private String handle;              // 사용자명
    private String login_id;            // 로그인 id
    private String login_password;      // 로그인 pw
    private String bio;                 // 자기소개
    private Long solved_count;           // 푼 문제 수
    private Long tier;                  // 티어 (1-31)
    private Long rating;                // 레이팅
    private Long rating_by_problems_sum;   // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long rating_by_solved_count;   // 푼 문제 수로 계산한 레이팅

    @Builder
    public MemberJoinRequestDto(
            String handle,
            String login_id,
            String login_password,
            String bio,
            Long solved_count,
            Long tier,
            Long rating,
            Long rating_by_problems_sum,
            Long rating_by_solved_count
    ) {
        this.handle = handle;
        this.login_id = login_id;
        this.login_password = login_password;
        this.bio = bio;
        this.solved_count = solved_count;
        this.tier = tier;
        this.rating = rating;
        this.rating_by_problems_sum = rating_by_problems_sum;
        this.rating_by_solved_count = rating_by_solved_count;
    }

}
