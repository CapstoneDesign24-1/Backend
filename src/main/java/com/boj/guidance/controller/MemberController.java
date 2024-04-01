package com.boj.guidance.controller;

import com.boj.guidance.dto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberResponseDto;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.util.api.ApiResponse;
import com.boj.guidance.util.api.ResponseCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 사용자 회원가입 기능
     * @param dto
     * @return
     */
    @PostMapping("/join")
    public ApiResponse<MemberResponseDto> join(@RequestBody MemberLoginRequestDto dto) {
        String encoded = passwordEncoder.encode(dto.getLogin_password());
        MemberResponseDto joined = memberService.join(
                MemberLoginRequestDto.builder()
                        .login_id(dto.getLogin_id())
                        .login_password(encoded)
                        .build()
        );
        return ApiResponse.success(ResponseCode.USER_JOIN_SUCCESS.getMessage(), joined);
    }

    /**
     * 사용자 로그인 기능
     * @param dto
     * @return
     */
    @GetMapping("/login")
    public ApiResponse<MemberResponseDto> login(@RequestBody MemberLoginRequestDto dto) {
        MemberResponseDto login = memberService.login(dto);
        return ApiResponse.success(ResponseCode.USER_LOGIN_SUCCESS.getMessage(), login);
    }

}
