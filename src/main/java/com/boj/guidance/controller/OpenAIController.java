package com.boj.guidance.controller;

import com.boj.guidance.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/openai")
@CrossOrigin(origins = {"*"})
public class OpenAIController {

    private final OpenAIService openAIService;

    @PostMapping("/analyze")
    public String analyzeCode(@RequestBody String codeContent) throws IOException {
        return openAIService.analyzeCode(codeContent);
    }
}
