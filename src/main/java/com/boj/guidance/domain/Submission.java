// src/main/java/com/boj/guidance/domain/Submission.java
package com.boj.guidance.domain;

import com.boj.guidance.util.annotation.LockName;
import com.boj.guidance.util.annotation.LockSerial;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Submission {
    @Id
    @LockSerial(keyPrefix = LockName.MEMBER)
    private Long id;
    private String codeContent;
    private String userName;
    private String submitId;
    private String userId;
    private String problemId;
    private String problemTitle;
    private String result;
    private String memory;
    private String time;
    private String language;
    private String codeLength;
}
