package com.boj.guidance.service;

import com.boj.guidance.dto.MemberDto.MemberAuthRequestDto;
import com.boj.guidance.dto.MemberDto.MemberJoinRequestDto;
import com.boj.guidance.dto.MemberDto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberDto.MemberResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

    @Transactional
    MemberResponseDto join(MemberJoinRequestDto dto);

    @Transactional(readOnly = true)
    MemberResponseDto login(MemberLoginRequestDto dto);

    MemberAuthRequestDto authorize();

    @Transactional
    MemberResponseDto changeRole(String memberId);

    @Transactional
    MemberResponseDto changeState(String memberId);

    @Transactional
    MemberResponseDto updateWeakAlgorithm(String memberId, String algorithm);

}
