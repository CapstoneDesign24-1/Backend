package com.boj.guidance.dto.MemberDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WeakAlgorithmRequestDto {
    private String image;
    private String weak;

    @Builder
    public WeakAlgorithmRequestDto(
            String image,
            String weak
    ) {
        this.image = image;
        this.weak = weak;
    }

}
