// src/main/java/com/boj/guidance/util/OpenAIClient.java
package com.boj.guidance.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class OpenAIClient {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Value("${openai.api.key}")
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getGPTResponse(String prompt) throws IOException {
        String requestBody = buildRequestBody(prompt);
        System.out.println("Request Body: " + requestBody); // 요청 본문을 로그에 출력

        RequestBody body = RequestBody.create(requestBody, JSON);
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + ", Response Body: " + response.body().string());
            }
            return response.body().string();
        }
    }

    private String buildRequestBody(String prompt) throws IOException {
        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o");
        requestBody.put("messages", new Map[]{message});
        requestBody.put("max_tokens", 150);
        requestBody.put("temperature", 0.7);

        return objectMapper.writeValueAsString(requestBody);
    }
}
