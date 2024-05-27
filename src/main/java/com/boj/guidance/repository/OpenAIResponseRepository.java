// src/main/java/com/boj/guidance/repository/OpenAIResponseRepository.java
package com.boj.guidance.repository;

import com.boj.guidance.domain.OpenAIResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenAIResponseRepository extends JpaRepository<OpenAIResponse, Long> {
}
