package com.boj.guidance.domain;

import com.boj.guidance.domain.enumerate.MemberRole;
import com.boj.guidance.dto.MemberResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member extends BaseEntity {

    private String handle;              // 사용자명
    private String login_id;            // 로그인 id
    private String login_password;      // 로그인 password
    private String bio;                 // 자기소개
    private Long solved_count;           // 푼 문제 수
    private Long tier;                  // 티어 (1-31)
    private Long rating;                // 레이팅
    private Long rating_by_problems_sum;   // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long rating_by_solved_count;   // 푼 문제 수로 계산한 레이팅
    @Enumerated(EnumType.STRING)
    private MemberRole role;            // 사용자 역할

    @Builder
    public Member(
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
        this.role = MemberRole.General;
    }

    public MemberResponseDto toResponse() {
        return MemberResponseDto.builder()
                .handle(this.getHandle())
                .bio(this.getBio())
                .solved_count(this.getSolved_count())
                .tier(this.getTier())
                .rating(this.getRating())
                .rating_by_problems_sum(this.getRating_by_problems_sum())
                .rating_by_solved_count(this.getRating_by_solved_count())
                .build();
    }

}
