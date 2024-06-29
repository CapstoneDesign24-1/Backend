package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class CommentException extends BaseException {
    public CommentException(ResponseCode code) {
        super(code);
    }
}
