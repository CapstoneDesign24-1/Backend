package com.boj.guidance.util.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LockName {

    MEMBER("member");

    private final String name;

}
