package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class IdGeneratorException extends BaseException {
    public IdGeneratorException(ResponseCode code) {
        super(code);
    }
}
