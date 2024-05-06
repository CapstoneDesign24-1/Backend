package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class EncodingException extends BaseException {
    public EncodingException(ResponseCode code) {
        super(code);
    }
}
