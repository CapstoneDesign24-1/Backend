package com.boj.guidance.domain.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StudyGroupState {
    WAITING("매칭 활성화"),
    NOT_WAITING("매칭 비활성화");
    private final String description;
}
