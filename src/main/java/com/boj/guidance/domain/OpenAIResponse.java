package com.boj.guidance.domain;

import com.boj.guidance.util.annotation.LockName;
import com.boj.guidance.util.annotation.LockSerial;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenAIResponse {
    @Id
    @LockSerial(keyPrefix = LockName.MEMBER)
    private Long id;
    private String submitId;
    private String response;
}
