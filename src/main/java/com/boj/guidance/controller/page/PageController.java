package com.boj.guidance.controller.page;

import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.DjangoException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
    @GetMapping("mypage")
    public String mypage(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("memberId");
        String apiUrl = "http://localhost:8000/analysis/image/" + userName;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, String> responseData = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, String>>() {});

            String encodedImage = responseData.get("image");
            encodedImage = "data:image/png;base64, " + encodedImage;

            model.addAttribute("image", encodedImage);
        } catch (JsonProcessingException e) {
            throw new DjangoException(ResponseCode.ANALYSIS_IMAGE_FAIL);
        }

        return "mypage";
    }

}
