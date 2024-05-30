package com.boj.guidance.controller.page;

import com.boj.guidance.dto.MemberDto.WeakAlgorithmRequestDto;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.DjangoException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PageController {

    private final MemberService memberService;

    // 로그인 페이지 이동
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 회원가입 페이지 이동
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    // 홈페이지 이동
    @GetMapping(value = {"/home", "/"})
    public String home(HttpSession session) {
        String userName = (String) session.getAttribute("memberId");
        return "home";
    }

    // 스터디그룹 페이지
    @GetMapping("/study")
    public String study(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("memberId");
        if (userName == null) {
            return "redirect:/login";
        }
        return "study";
    }

    // 문제 추천 페이지
    @GetMapping("/recommendation")
    public String recommendation(HttpSession session) {
        String userName = (String) session.getAttribute("memberId");
        if (userName != null) {
            return "recommendation";
        } else {
            return "redirect:/login";
        }
    }

    // 코드 분석 페이지
    @GetMapping("/codeAnalysis")
    public String codeAnalysis(HttpSession session) {
        String userName = (String) session.getAttribute("memberId");
        if (userName != null) {
            return "codeAnalysis";
        } else {
            return "redirect:/login";
        }
    }

    // 커뮤니티 페이지
    @GetMapping("/community")
    public String community(HttpSession session) {
        String userName = (String) session.getAttribute("memberId");
        if (userName != null) {
            return "community";
        } else {
            return "redirect:/login";
        }
    }

    // 나는 어디쯤일까? 페이지
    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("memberId");
        WeakAlgorithmRequestDto dto = memberService.init(userName);
        model.addAttribute("image", dto.getImage());
        model.addAttribute("weak", dto.getWeak());
        return "mypage";
    }

    @GetMapping("/init")
    public String init(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("memberId");
        model.addAttribute("handle", userName);
        return "init";
    }

}
