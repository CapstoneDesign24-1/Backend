package com.boj.guidance.service.implement;

import com.boj.guidance.domain.Member;
import com.boj.guidance.dto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberResponseDto;
import com.boj.guidance.repository.MemberRepository;
import com.boj.guidance.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberRepository memberRepository, RestTemplate restTemplate, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.restTemplate = restTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MemberResponseDto join(MemberLoginRequestDto dto) {
        String url = "/account/verify_credentials";
        try {
            ResponseEntity<MemberResponseDto> entity = restTemplate.getForEntity(url, MemberResponseDto.class);
            MemberResponseDto entityBody = entity.getBody();
            memberRepository.save(
                    Member.builder()
                            .handle(entityBody.getHandle())
                            .login_id(dto.getLogin_id())
                            .login_password(dto.getLogin_password())
                            .bio(entityBody.getBio())
                            .solvedCount(entityBody.getSolvedCount())
                            .tier(entityBody.getTier())
                            .ratingByProblemsSum(entityBody.getRatingByProblemsSum())
                            .ratingBySolvedCount(entityBody.getRatingBySolvedCount())
                            .build()
            );
            return entityBody;
        } catch (HttpClientErrorException.Forbidden e) {
            // TODO 사용자 Exception 오류 핸들링 (회원가입 실패)
            log.error("인증에 실패했습니다.", e);
        }
        return null;
    }

    @Override
    public MemberResponseDto login(MemberLoginRequestDto dto) {
        Optional<Member> findMember = memberRepository.findMemberByLogin_idAndLogin_password(dto.getLogin_id(), passwordEncoder.encode(dto.getLogin_password()));
        if (findMember.isEmpty()) {
            throw new RuntimeException();
            // TODO 사용자 Exception 오류 핸들링 (사용자 정보 없음)
        }
        // TODO 세션 관리 로직 추가
        return findMember.get().toResponse();
    }

}