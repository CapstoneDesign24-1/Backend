package com.boj.guidance.util.exception;

import com.boj.guidance.util.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public ApiResponse<Void> userExceptionHandling(MemberException e) {
        log.error("MemberException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(StudyGroupException.class)
    public ApiResponse<Void> studyGroupExceptionHandling(StudyGroupException e) {
        log.error("StudyGroupException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(ProblemException.class)
    public ApiResponse<Void> problemExceptionHandling(ProblemException e) {
        log.error("ProblemException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(IdGeneratorException.class)
    public ApiResponse<Void> idGeneratorExceptionHandling(IdGeneratorException e) {
        log.error("IdGeneratorException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(EncodingException.class)
    public ApiResponse<Void> encodingExceptionHandling(EncodingException e) {
        log.error("EncodingException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(DjangoException.class)
    public ApiResponse<Void> djangoExceptionHandling(DjangoException e) {
        log.error("DjangoException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(CodeAnalysisException.class)
    public ApiResponse<Void> codeAnalysisExceptionHandling(CodeAnalysisException e) {
        log.error("CodeAnalysisException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(PostException.class)
    public ApiResponse<Void> postExceptionHandling(PostException e) {
        log.error("PostException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

    @ExceptionHandler(CommentException.class)
    public ApiResponse<Void> commentExceptionHandling(CommentException e) {
        log.error("CommentException: {}", e.getMessage());
        return ApiResponse.fail(e.getCode(), null);
    }

}
