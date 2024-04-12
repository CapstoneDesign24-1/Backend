package com.boj.guidance.util.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseCode {

    // 사용자 관련 오류
    USER_AUTH_FAIL(HttpStatus.UNAUTHORIZED, false, "사용자 인증 실패"),
    USER_JOIN_FAIL(HttpStatus.UNAUTHORIZED, false, "회원가입 실패"),
    USER_LOGIN_FAIL(HttpStatus.UNAUTHORIZED, false, "로그인 실패"),

    // 성공
    USER_AUTH_SUCCESS(HttpStatus.ACCEPTED, true, "사용자 인증 성공"),
    USER_LOGIN_SUCCESS(HttpStatus.CREATED, true, "로그인 성공"),
    USER_JOIN_SUCCESS(HttpStatus.CREATED, true, "회원가입 성공");

    private final HttpStatus httpStatus;
    private final Boolean success;
    private final String message;

    public Integer getCode() {
        return httpStatus.value();
    }
}
