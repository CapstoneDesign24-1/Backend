package com.boj.guidance.dto.ProblemDto;

import com.boj.guidance.domain.Problem;
import com.boj.guidance.util.TierUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProblemResponseDto {
    private Integer problemId;
    private String title;
    private String link;
    private String level;
    private Long numberOfSolved;
    private float avgTry;
    private List<String> algorithms;

    @Builder
    public ProblemResponseDto(
            Integer problemId,
            String title,
            String link,
            Integer level,
            Long numberOfSolved,
            float avgTry,
            List<String> algorithms
    ) {
        this.problemId = problemId;
        this.title = title;
        this.link = link;
        this.level = TierUtil.checkTier(level.longValue());
        this.numberOfSolved = numberOfSolved;
        this.avgTry = avgTry;
        this.algorithms = algorithms;
    }

    public ProblemResponseDto toResponse(
            Problem entity,
            List<String> algorithms
    ) {
        return ProblemResponseDto.builder()
                .problemId(entity.getProblemId())
                .title(entity.getTitle())
                .link(entity.getLink())
                .level(entity.getLevel())
                .numberOfSolved(entity.getNumberOfSolved())
                .avgTry(entity.getAvgTry())
                .algorithms(algorithms)
                .build();
    }
}
