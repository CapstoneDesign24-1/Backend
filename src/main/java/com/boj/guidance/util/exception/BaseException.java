package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private final ResponseCode code;

    @Override
    public String getMessage() {
        return code.getMessage();
    }
}
