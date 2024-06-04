package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class CodeAnalysisException extends BaseException {

    public CodeAnalysisException(ResponseCode code) {
        super(code);
    }

    public CodeAnalysisException(ResponseCode code, Throwable cause) {
        super(code, cause);
    }
}
