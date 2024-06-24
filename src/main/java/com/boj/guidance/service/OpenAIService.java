package com.boj.guidance.service;

import java.io.IOException;

public interface OpenAIService {
    String analyzeCode(String codeContent) throws IOException;
}
