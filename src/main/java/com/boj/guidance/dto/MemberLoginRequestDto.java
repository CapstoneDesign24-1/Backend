package com.boj.guidance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginRequestDto {
    private String login_id;
    private String login_password;

    @Builder
    public MemberLoginRequestDto(
            String login_id,
            String login_password
    ) {
        this.login_id = login_id;
        this.login_password = login_password;
    }
}
