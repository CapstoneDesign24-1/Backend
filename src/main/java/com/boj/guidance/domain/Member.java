package com.boj.guidance.domain;

import com.boj.guidance.domain.base.BaseEntity;
import com.boj.guidance.domain.enumerate.MemberRole;
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

    private String handle;                  // 사용자명
    private String loginId;                 // 로그인 id
    private String loginPassword;           // 로그인 password
    private String bio;                     // 자기소개
    private Long solvedCount;               // 푼 문제 수
    private Long tier;                      // 티어 (1-31)
    private Long rating;                    // 레이팅
    private Long ratingByProblemsSum;       // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long ratingBySolvedCount;       // 푼 문제 수로 계산한 레이팅
    @Enumerated(EnumType.STRING)
    private MemberRole role;                // 사용자 역할

    @Builder
    public Member(
            String handle,
            String loginId,
            String loginPassword,
            String bio,
            Long solvedCount,
            Long tier,
            Long rating,
            Long ratingByProblemsSum,
            Long ratingBySolvedCount
    ) {
        this.handle = handle;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.bio = bio;
        this.solvedCount = solvedCount;
        this.tier = tier;
        this.rating = rating;
        this.ratingByProblemsSum = ratingByProblemsSum;
        this.ratingBySolvedCount = ratingBySolvedCount;
        this.role = MemberRole.USER;
    }

}
