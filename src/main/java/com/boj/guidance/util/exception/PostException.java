package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class PostException extends BaseException {
    public PostException(ResponseCode code) {
        super(code);
    }
}
