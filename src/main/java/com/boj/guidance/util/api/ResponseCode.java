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
    USER_ROLE_CHANGE_FAIL(HttpStatus.BAD_REQUEST, false, "Role 변경 실패"),
    USER_NOT_EXIST(HttpStatus.BAD_REQUEST, false, "사용자 정보 없음"),

    // 비밀번호 암호화 관련 오류
    PASSWORD_ENCRYPT_FAIL(HttpStatus.CONFLICT, false, "암호화 실패"),

    // 문제 관련 오류
    PROBLEM_FIND_FAIL(HttpStatus.BAD_REQUEST, false, "문제 검색 실패"),
    PROBLEM_RECOMMEND_FAIL(HttpStatus.BAD_REQUEST, false, "문제 추천 실패"),
  
    // Django 서버 관련 오류
    ANALYSIS_IMAGE_FAIL(HttpStatus.BAD_REQUEST, false, "분석 이미지 오류"),

    // 성공
    USER_AUTH_SUCCESS(HttpStatus.ACCEPTED, true, "사용자 인증 성공"),
    USER_LOGIN_SUCCESS(HttpStatus.CREATED, true, "로그인 성공"),
    USER_JOIN_SUCCESS(HttpStatus.CREATED, true, "회원가입 성공"),
    USER_ROLE_CHANGE_SUCCESS(HttpStatus.ACCEPTED, true, "Role 변경 성공"),
    ALGORITHM_NAME_SEARCH_SUCCESS(HttpStatus.ACCEPTED, true, "문제 검색 성공"),
    PROBLEM_RECOMMEND_SUCCESS(HttpStatus.ACCEPTED, true, "문제 추천 성공");

    private final HttpStatus httpStatus;
    private final Boolean success;
    private final String message;

    public Integer getCode() {
        return httpStatus.value();
    }
}
