package com.boj.guidance.controller;

import com.boj.guidance.config.PasswordEncoder;
import com.boj.guidance.dto.MemberJoinRequestDto;
import com.boj.guidance.dto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberResponseDto;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.util.api.ApiResponse;
import com.boj.guidance.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    /**
     * 사용자 회원가입 기능
     * @param dto
     * @return
     */
    @PostMapping("/join")
    public ApiResponse<MemberResponseDto> join(@RequestBody MemberJoinRequestDto dto) throws Exception {
        log.info("회원가입 API 호출");
        String encoded = passwordEncoder.encrypt(dto.getLogin_password());
        MemberResponseDto joined = memberService.join(
                MemberJoinRequestDto.builder()
                        .handle(dto.getHandle())
                        .login_id(dto.getLogin_id())
                        .login_password(encoded)
                        .bio(dto.getBio())
                        .solved_count(dto.getSolved_count())
                        .tier(dto.getTier())
                        .rating(dto.getRating())
                        .rating_by_problems_sum(dto.getRating_by_problems_sum())
                        .rating_by_solved_count(dto.getRating_by_solved_count())
                        .build()
        );
        return ApiResponse.success(ResponseCode.USER_JOIN_SUCCESS.getMessage(), joined);
    }

    /**
     * 사용자 로그인 기능
     */
    @PostMapping("/login")
    public ApiResponse<MemberResponseDto> login(@RequestBody MemberLoginRequestDto dto) throws Exception {
        log.info("로그인 API 호출");
        String encoded = passwordEncoder.encrypt(dto.getLogin_password());
        MemberResponseDto login = memberService.login(MemberLoginRequestDto.builder()
                .login_id(dto.getLogin_id())
                .login_password(encoded)
                .build());
        return ApiResponse.success(ResponseCode.USER_LOGIN_SUCCESS.getMessage(), login);
    }

    /**
     * 백준 사용자 인증하기
     */
    @PostMapping("/auth")
    public MemberResponseDto authorize() {
        log.info("인증 API 호출");
        return memberService.authorize();
    }

}
