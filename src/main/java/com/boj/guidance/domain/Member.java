package com.boj.guidance.domain;

import com.boj.guidance.domain.enumerate.MemberRole;
import com.boj.guidance.util.annotation.LockName;
import com.boj.guidance.util.annotation.LockSerial;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @LockSerial(keyPrefix = LockName.MEMBER)
    private String id;
    private String createdAt;
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
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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
