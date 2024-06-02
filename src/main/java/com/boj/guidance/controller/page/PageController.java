package com.boj.guidance.controller.page;

import com.boj.guidance.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final MemberRepository memberRepository;

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

    // 스터디 페이지
    @GetMapping("/study")
    public String study(HttpSession session) {
        String userName = (String) session.getAttribute("memberId");
        if (userName != null) {
            return "study";
        } else {
            return "redirect:/login";
        }
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
        String memberId = (String) session.getAttribute("memberId");
        if (memberId != null) {
            return memberRepository.findHandleById(memberId)
                    .map(handle -> "redirect:/codeAnalysis/" + handle)
                    .orElse("redirect:/login");
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
}
