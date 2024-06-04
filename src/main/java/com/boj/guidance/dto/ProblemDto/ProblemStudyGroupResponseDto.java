package com.boj.guidance.dto.ProblemDto;

import com.boj.guidance.domain.Problem;
import com.boj.guidance.util.TierUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemStudyGroupResponseDto {
    private Integer problemId;
    private String title;
    private String link;
    private String level;
    private Long numberOfSolved;
    private float avgTry;

    @Builder
    public ProblemStudyGroupResponseDto(
            Integer problemId,
            String title,
            String link,
            Integer level,
            Long numberOfSolved,
            float avgTry
    ) {
        this.problemId = problemId;
        this.title = title;
        this.link = link;
        this.level = TierUtil.checkTier(level.longValue());
        this.numberOfSolved = numberOfSolved;
        this.avgTry = avgTry;
    }

    public ProblemStudyGroupResponseDto toResponse(
            Problem entity
    ) {
        return ProblemStudyGroupResponseDto.builder()
                .problemId(entity.getProblemId())
                .title(entity.getTitle())
                .link(entity.getLink())
                .level(entity.getLevel())
                .numberOfSolved(entity.getNumberOfSolved())
                .avgTry(entity.getAvgTry())
                .build();
    }
}
