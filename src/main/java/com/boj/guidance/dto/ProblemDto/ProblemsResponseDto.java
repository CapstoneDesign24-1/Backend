package com.boj.guidance.dto.ProblemDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProblemsResponseDto {
    private List<ProblemResponseDto> problemResponseDtos;
    private int count;

    @Builder
    public ProblemsResponseDto(
            List<ProblemResponseDto> problemResponseDtos,
            int count
    ) {
        this.problemResponseDtos = problemResponseDtos;
        this.count = count;
    }

    public ProblemsResponseDto toArray(
            List<ProblemResponseDto> problemResponseDtos,
            int count
    ) {
        return ProblemsResponseDto.builder()
                .problemResponseDtos(problemResponseDtos)
                .count(count)
                .build();
    }
}
