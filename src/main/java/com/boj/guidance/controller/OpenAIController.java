// src/main/java/com/boj/guidance/controller/OpenAIController.java
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
    public String analyzeCode(@RequestBody String codeContent) {
        try {
            return openAIService.analyzeCode(codeContent);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while processing the request.";
        }
    }
}
