package com.boj.guidance.dto.MemberDto;

import com.boj.guidance.domain.Member;
import com.boj.guidance.domain.StudyGroup;
import com.boj.guidance.domain.enumerate.StudyGroupState;
import com.boj.guidance.util.TierUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private String id;                      // id
    private String role;                    // role
    private String handle;                  // 사용자명
    private String bio;                     // 자기소개
    private Long solvedCount;               // 푼 문제 수
    private String tier;                    // 티어 (1-31)
    private Long rating;                    // 레이팅
    private Long ratingByProblemsSum;       // 푼 문제의 난이도 합으로 계산한 레이팅
    private Long ratingBySolvedCount;       // 푼 문제 수로 계산한 레이팅
    private StudyGroupState state;          // 스터디그룹 모집 활성화 여부
    private List<String> weakAlgorithms;    // 취약 알고리즘
    private String studyGroup;              // 가입한 스터디그룹

    @Builder
    public MemberResponseDto(
            String id,
            String role,
            String handle,
            String bio,
            Long solvedCount,
            String tier,
            Long rating,
            Long ratingByProblemsSum,
            Long ratingBySolvedCount,
            StudyGroupState state,
            String weakAlgorithms,
            StudyGroup studyGroup
    ) {
        this.id = id;
        this.role = role;
        this.handle = handle;
        this.bio = bio;
        this.solvedCount = solvedCount;
        this.tier = tier;
        this.rating = rating;
        this.ratingByProblemsSum = ratingByProblemsSum;
        this.ratingBySolvedCount = ratingBySolvedCount;
        this.state = state;
        if (weakAlgorithms != null) {
            this.weakAlgorithms = new ArrayList<>(Arrays.asList(weakAlgorithms.split(",")));
        } else {
            this.weakAlgorithms = null;
        }
        if (studyGroup != null) {
            this.studyGroup = studyGroup.getId();
        } else {
            this.studyGroup = null;
        }
    }

    public MemberResponseDto toResponse(Member entity) {
        return MemberResponseDto.builder()
                .id(entity.getId())
                .role(entity.getRole().toString())
                .handle(entity.getHandle())
                .bio(entity.getBio())
                .solvedCount(entity.getSolvedCount())
                .tier(TierUtil.checkTier(entity.getTier()))
                .rating(entity.getRating())
                .ratingByProblemsSum(entity.getRatingByProblemsSum())
                .ratingBySolvedCount(entity.getRatingBySolvedCount())
                .state(entity.getState())
                .weakAlgorithms(entity.getWeakAlgorithm())
                .studyGroup(entity.getStudyGroup())
                .build();
    }
}
