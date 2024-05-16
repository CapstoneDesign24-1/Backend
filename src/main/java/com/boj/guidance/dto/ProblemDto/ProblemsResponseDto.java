package com.boj.guidance.dto.ProblemDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProblemsResponseDto {
    private List<ProblemResponseDto> problems;
    private int count;

    @Builder
    public ProblemsResponseDto(
            List<ProblemResponseDto> problems,
            int count
    ) {
        this.problems = problems;
        this.count = count;
    }

    public ProblemsResponseDto toArray(
            List<ProblemResponseDto> problems,
            int count
    ) {
        return ProblemsResponseDto.builder()
                .problems(problems)
                .count(count)
                .build();
    }
}
