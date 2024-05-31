package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ResponseCode;

public class StudyGroupException extends BaseException {
    public StudyGroupException(ResponseCode code) {
        super(code);
    }
}
