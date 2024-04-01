package com.boj.guidance.domain.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    General("일반 사용자"), Admin("관리자");
    private final String role;
}
