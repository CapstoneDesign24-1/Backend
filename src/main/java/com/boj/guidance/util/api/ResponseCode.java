package com.boj.guidance.util.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseCode {

    // Id 생성 오류
    ID_GENERATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, false, "아이디 생성 실패"),
    REDIS_LOCK_FAIL(HttpStatus.LOCKED, false, "Redis Lock 실패"),

    // 사용자 관련 오류
    USER_AUTH_FAIL(HttpStatus.UNAUTHORIZED, false, "사용자 인증 실패"),
    USER_JOIN_FAIL(HttpStatus.UNAUTHORIZED, false, "회원가입 실패"),
    USER_LOGIN_FAIL(HttpStatus.UNAUTHORIZED, false, "로그인 실패"),

    // 비밀번호 암호화 관련 오류
    PASSWORD_ENCRYPT_FAIL(HttpStatus.CONFLICT, false, "암호화 실패"),

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
