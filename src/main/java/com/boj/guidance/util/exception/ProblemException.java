package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class ProblemException extends BaseException {
    public ProblemException(ResponseCode code) {
        super(code);
    }
}
