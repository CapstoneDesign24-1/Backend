package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class MemberException extends BaseException {
    public MemberException(ResponseCode code) {
        super(code);
    }
}
