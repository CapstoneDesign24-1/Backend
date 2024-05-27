package com.boj.guidance.service.implement;

import com.boj.guidance.config.PasswordEncoder;
import com.boj.guidance.domain.Member;
import com.boj.guidance.domain.enumerate.StudyGroupState;
import com.boj.guidance.dto.MemberDto.*;
import com.boj.guidance.repository.MemberRepository;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 사용자 회원가입 기능 구현
    @Override
    public MemberResponseDto join(MemberJoinRequestDto dto) {
        if (memberRepository.findByLoginId(dto.getLoginId()).isPresent()) { // 회원가입 하려는 사용자 id가 이미 존재하면 ERROR
            throw new UserException(ResponseCode.USER_JOIN_FAIL);
        }
        Member saved = memberRepository.save(dto.toEntity(passwordEncoder.encrypt(dto.getLoginPassword())));

        return new MemberResponseDto().toResponse(saved);
    }

    // 사용자 로그인 기능 구현
    @Override
    public MemberResponseDto login(MemberLoginRequestDto dto) {
        Optional<Member> findMember = memberRepository.findMemberByLoginIdAndLoginPassword(
                dto.getLoginId(),
                passwordEncoder.encrypt(dto.getLoginPassword())
        );
        if (findMember.isEmpty()) {
            throw new UserException(ResponseCode.USER_LOGIN_FAIL);
        }
        return new MemberResponseDto().toResponse(findMember.get());
    }

    // 백준 사용자 인증 구현
    // 단, solved.ac 페이지에 로그인이 되어 있어야 한다.
    @Override
    public MemberAuthRequestDto authorize() {
        WebClient webClient = WebClient.create();
        WebClientRequestDto dto = webClient.get()
                .uri("https://solved.ac/api/v3/account/verify_credentials")
                .retrieve()
                .bodyToMono(WebClientRequestDto.class)
                .block();

        return dto.getUser();
    }

    // 사용자 권한 변경
    @Override
    public MemberResponseDto changeRole(String memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new UserException(ResponseCode.USER_NOT_EXIST)
        );
        member.roleUpdate();
        return new MemberResponseDto().toResponse(memberRepository.save(member));
    }

    // 사용자 스터디그룹 모집 활성화 상태 변경
    @Override
    public MemberResponseDto changeState(String memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new UserException(ResponseCode.USER_NOT_EXIST)
        );
        member.stateUpdate();
        return new MemberResponseDto().toResponse(memberRepository.save(member));
    }

    @Override
    public MemberResponseDto updateWeakAlgorithm(String memberId, String algorithm) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new UserException(ResponseCode.USER_NOT_EXIST)
        );
        member.setWeakAlgorithm(algorithm);
        return new MemberResponseDto().toResponse(memberRepository.save(member));
    }
}