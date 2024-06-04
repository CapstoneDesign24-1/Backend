package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class DjangoException extends BaseException {
    public DjangoException(ResponseCode code) {
        super(code);
    }
}
