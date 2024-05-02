package com.boj.guidance.controller.page;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

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
        if (userName != null) {
            return "home";
        } else {
            return "redirect:/login";
        }
    }

}
