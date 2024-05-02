package com.boj.guidance.dto;

import com.boj.guidance.domain.Member;
import com.boj.guidance.util.MemberTierUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private String id;                      // id
    private String handle;                  // 사용자명
    private String bio;                     // 자기소개
    private Long solvedCount;               // 푼 문제 수
    private String tier;                    // 티어 (1-31)
    private Long rating;                    // 레이팅
    private Long ratingByProblemsSum;       // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long ratingBySolvedCount;       // 푼 문제 수로 계산한 레이팅

    @Builder
    public MemberResponseDto(
            String id,
            String handle,
            String bio,
            Long solvedCount,
            String tier,
            Long rating,
            Long ratingByProblemsSum,
            Long ratingBySolvedCount
    ) {
        this.id = id;
        this.handle = handle;
        this.bio = bio;
        this.solvedCount = solvedCount;
        this.tier = tier;
        this.rating = rating;
        this.ratingByProblemsSum = ratingByProblemsSum;
        this.ratingBySolvedCount = ratingBySolvedCount;
    }

    public MemberResponseDto toResponse(Member entity) {
        return MemberResponseDto.builder()
                .id(entity.getId())
                .handle(entity.getHandle())
                .bio(entity.getBio())
                .solvedCount(entity.getSolvedCount())
                .tier(MemberTierUtil.checkTier(entity.getTier()))
                .rating(entity.getRating())
                .ratingByProblemsSum(entity.getRatingByProblemsSum())
                .ratingBySolvedCount(entity.getRatingBySolvedCount())
                .build();
    }
}
