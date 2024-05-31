package com.boj.guidance.controller.page;

import com.boj.guidance.dto.MemberDto.WeakAlgorithmRequestDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupResponseDto;
import com.boj.guidance.service.MemberService;
import com.boj.guidance.service.StudyGroupService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PageController {

    private final MemberService memberService;
    private final StudyGroupService studyGroupService;

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
        Optional<StudyGroupResponseDto> dto = studyGroupService.checkIfMemberJoined(userName);
        if (dto.isPresent()) {
            model.addAttribute("group", dto.get());
        } else {
            model.addAttribute("group", null);
        }
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
