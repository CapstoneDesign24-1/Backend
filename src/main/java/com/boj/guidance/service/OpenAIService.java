// src/main/java/com/boj/guidance/service/OpenAIService.java
package com.boj.guidance.service;

import com.boj.guidance.util.OpenAIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class OpenAIService {

    private final OpenAIClient openAIClient;

    public String analyzeCode(String codeContent) throws IOException {
        String prompt = "Analyze the following code for time efficiency, space efficiency, and suggest improvements:\n" + codeContent;
        return openAIClient.getGPTResponse(prompt);
    }
}
