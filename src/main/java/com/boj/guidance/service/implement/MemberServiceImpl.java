package com.boj.guidance.service.implement;

import com.boj.guidance.config.PasswordEncoder;
import com.boj.guidance.domain.Member;
import com.boj.guidance.dto.MemberDto.*;
import com.boj.guidance.repository.MemberRepository;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.DjangoException;
import com.boj.guidance.util.exception.MemberException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Value("${django.server.address}")
    private String ADDRESS;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 사용자 회원가입 기능 구현
    @Override
    public MemberResponseDto join(MemberJoinRequestDto dto) {
        if (memberRepository.findByLoginId(dto.getLoginId()).isPresent()) { // 회원가입 하려는 사용자 id가 이미 존재하면 ERROR
            throw new MemberException(ResponseCode.MEMBER_JOIN_FAIL);
        }
        Member saved = memberRepository.save(dto.toEntity(passwordEncoder.encrypt(dto.getLoginPassword())));

        return new MemberResponseDto().toResponse(saved);
    }

    // 사용자 로그인 기능 구현
    @Override
    public MemberResponseDto login(MemberLoginRequestDto dto) {
        Member member = memberRepository.findMemberByLoginIdAndLoginPassword(
                dto.getLoginId(),
                passwordEncoder.encrypt(dto.getLoginPassword())
        ).orElseThrow(
                () -> new MemberException(ResponseCode.MEMBER_LOGIN_FAIL)
        );
        return new MemberResponseDto().toResponse(member);
    }

    // 로그인 시 사용자 정보 새로고침
    @Cacheable(value = "init", key = "#handle")
    @Override
    public WeakAlgorithmRequestDto init(String handle) {
        Member member = memberRepository.findByHandle(handle).orElseThrow(
                () -> new MemberException(ResponseCode.MEMBER_NOT_EXIST)
        );
        String apiUrl = ADDRESS + "/analysis/image/" + member.getHandle();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> responseData = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, String>>() {});
            String image = "data:image/png;base64, " + responseData.get("image");
            String weakAlgorithms = String.valueOf(responseData.get("weak")).replace("[", "").replace("]", "").replaceAll(" ", "");
            member.setWeakAlgorithm(weakAlgorithms);
            return WeakAlgorithmRequestDto.builder()
                    .image(image)
                    .weak(weakAlgorithms)
                    .build();
        } catch (JsonProcessingException e) {
            log.error(e.toString());
            throw new DjangoException(ResponseCode.ANALYSIS_IMAGE_FAIL);
        }
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
                () -> new MemberException(ResponseCode.MEMBER_NOT_EXIST)
        );
        member.roleUpdate();
        return new MemberResponseDto().toResponse(memberRepository.save(member));
    }

    // 사용자 스터디그룹 모집 활성화 상태 변경
    @Override
    public MemberResponseDto changeState(String memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberException(ResponseCode.MEMBER_NOT_EXIST)
        );
        member.stateUpdate();
        return new MemberResponseDto().toResponse(memberRepository.save(member));
    }

    // 취약 알고리즘 업데이트
    @Override
    public MemberResponseDto updateWeakAlgorithm(String handle, String algorithm) {
        Member member = memberRepository.findByHandle(handle).orElseThrow(
                () -> new MemberException(ResponseCode.MEMBER_NOT_EXIST)
        );
        member.setWeakAlgorithm(algorithm);
        return new MemberResponseDto().toResponse(memberRepository.save(member));
    }
}
