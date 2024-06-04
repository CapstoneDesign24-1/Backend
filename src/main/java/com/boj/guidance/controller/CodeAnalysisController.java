package com.boj.guidance.controller;

import com.boj.guidance.domain.CodeAnalysis;
import com.boj.guidance.repository.CodeAnalysisRepository;
import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.CodeAnalysisException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CodeAnalysisController {

    private final CodeAnalysisRepository codeAnalysisRepository;
    private final ObjectMapper objectMapper;

    @GetMapping("/codeAnalysis/{username}")
    public String getCodeAnalysisList(@PathVariable String username,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) String keyword,
                                      Model model) {
        List<CodeAnalysis> responses;

        if (category != null && keyword != null && !keyword.isEmpty()) {
            switch (category) {
                case "submitId":
                    responses = codeAnalysisRepository.findByUserNameAndSubmitIdContaining(username, keyword);
                    break;
                case "problemId":
                    responses = codeAnalysisRepository.findByUserNameAndProblemIdContaining(username, keyword);
                    break;
                case "problemTitle":
                    responses = codeAnalysisRepository.findByUserNameAndProblemTitleContaining(username, keyword);
                    break;
                default:
                    responses = codeAnalysisRepository.findByUserName(username);
            }
        } else {
            responses = codeAnalysisRepository.findByUserName(username);
        }

        model.addAttribute("responses", responses);
        model.addAttribute("username", username);
        return "codeAnalysis";
    }

    @GetMapping("/codeAnalysis/{username}/{id}")
    public String getCodeAnalysisDetail(@PathVariable String username, @PathVariable String id, Model model) {
        CodeAnalysis response = codeAnalysisRepository.findById(id).orElseThrow(
                () -> new CodeAnalysisException(ResponseCode.CODEANALYSIS_FAIL)
        );

        try {
            JsonNode root = objectMapper.readTree(response.getResponse());
            String time = root.path("time").asText();
            String memory = root.path("memory").asText();
            String suggest = root.path("suggest").asText();

            model.addAttribute("time", time);
            model.addAttribute("memory", memory);
            model.addAttribute("suggest", suggest);
        } catch (IOException e) {
            throw new CodeAnalysisException(ResponseCode.CODEANALYSIS_FAIL, e);
        }

        model.addAttribute("response", response);
        model.addAttribute("username", username);
        return "codeAnalysisDetail";
    }
}
