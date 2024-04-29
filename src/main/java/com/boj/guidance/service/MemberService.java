package com.boj.guidance.service;

import com.boj.guidance.dto.MemberAuthRequestDto;
import com.boj.guidance.dto.MemberJoinRequestDto;
import com.boj.guidance.dto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

    @Transactional
    MemberResponseDto join(MemberJoinRequestDto dto);

    @Transactional(readOnly = true)
    MemberResponseDto login(MemberLoginRequestDto dto);

    MemberAuthRequestDto authorize();

}
