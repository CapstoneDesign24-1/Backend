package com.boj.guidance.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class MemberLoginRequestDto {
    private String loginId;
    private String loginPassword;
}
