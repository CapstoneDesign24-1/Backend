package com.boj.guidance.service.implement;

import com.boj.guidance.config.PasswordEncoder;
import com.boj.guidance.domain.Member;
import com.boj.guidance.dto.MemberJoinRequestDto;
import com.boj.guidance.dto.MemberLoginRequestDto;
import com.boj.guidance.dto.MemberResponseDto;
import com.boj.guidance.repository.MemberRepository;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public MemberResponseDto join(MemberJoinRequestDto dto) {
        Optional<Member> findMember = memberRepository.findMemberByLogin_idAndLogin_password(dto.getLogin_id(), dto.getLogin_password());
        if (findMember.isPresent()) {
            throw new UserException(ResponseCode.USER_JOIN_FAIL);
        }

        Member saved = memberRepository.save(
                Member.builder()
                        .handle(dto.getHandle())
                        .login_id(dto.getLogin_id())
                        .login_password(dto.getLogin_password())
                        .bio(dto.getBio())
                        .solved_count(dto.getSolved_count())
                        .tier(dto.getTier())
                        .rating(dto.getRating())
                        .rating_by_problems_sum(dto.getRating_by_problems_sum())
                        .rating_by_solved_count(dto.getRating_by_solved_count())
                        .build()
        );

        return saved.toResponse();
    }

    @Override
    public MemberResponseDto login(MemberLoginRequestDto dto) {
        Optional<Member> findMember = memberRepository.findMemberByLogin_idAndLogin_password(dto.getLogin_id(), dto.getLogin_password());
        if (findMember.isEmpty()) {
            throw new UserException(ResponseCode.USER_LOGIN_FAIL);
        }
        return findMember.get().toResponse();
    }

    @Override
    public MemberResponseDto authorize() {
        String url = "/account/verify_credentials";
        try {
            ResponseEntity<MemberResponseDto> entity = restTemplate.getForEntity(url, MemberResponseDto.class);
            log.info(entity.getBody().toString());
            return entity.getBody();
        } catch (HttpClientErrorException.Forbidden e) {
            throw new UserException(ResponseCode.USER_JOIN_FAIL);
        } catch (Exception e) {
            log.error("인증 실패", e);
        }
        return null;
    }

}