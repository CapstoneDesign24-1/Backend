package com.boj.guidance.dto.MemberDto;

import lombok.*;

@Getter
@NoArgsConstructor
public class MemberLoginRequestDto {
    private String loginId;
    private String loginPassword;
}
