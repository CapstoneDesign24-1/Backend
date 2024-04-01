package com.boj.guidance.service;

import com.boj.guidance.dto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

    @Transactional
    MemberResponseDto join(MemberLoginRequestDto dto);

    @Transactional(readOnly = true)
    MemberResponseDto login(MemberLoginRequestDto dto);

}
