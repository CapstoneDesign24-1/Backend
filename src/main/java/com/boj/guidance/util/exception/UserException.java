package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class UserException extends BaseException {
    public UserException(ResponseCode code) {
        super(code);
    }
}
