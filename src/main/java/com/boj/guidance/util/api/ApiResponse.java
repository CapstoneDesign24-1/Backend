package com.boj.guidance.util.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;


@Getter
public class ApiResponse<T> {

    private final Integer code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public ApiResponse(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> ApiResponse<T> success(String message, T result) {
        return new ApiResponse<T>(200, message, result);
    }

    public static <T> ApiResponse<T> fail(ResponseCode code, T result) {
        return new ApiResponse<T>(code.getCode(), code.getMessage(), result);
    }

}
