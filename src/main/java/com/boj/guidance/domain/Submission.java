// src/main/java/com/boj/guidance/domain/Submission.java
package com.boj.guidance.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("codeContent")
    private String codeContent;

    @JsonProperty("username")
    private String username;

    @JsonProperty("submitId")
    private String submitId;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("problemId")
    private String problemId;

    @JsonProperty("problemTitle")
    private String problemTitle;

    @JsonProperty("result")
    private String result;

    @JsonProperty("memory")
    private String memory;

    @JsonProperty("time")
    private String time;

    @JsonProperty("language")
    private String language;

    @JsonProperty("codeLength")
    private String codeLength;

    // getters and setters

    @Override
    public String toString() {
        return "Submission{" +
                "id=" + id +
                ", codeContent='" + codeContent + '\'' +
                ", username='" + username + '\'' +
                ", submitId='" + submitId + '\'' +
                ", userId='" + userId + '\'' +
                ", problemId='" + problemId + '\'' +
                ", problemTitle='" + problemTitle + '\'' +
                ", result='" + result + '\'' +
                ", memory='" + memory + '\'' +
                ", time='" + time + '\'' +
                ", language='" + language + '\'' +
                ", codeLength='" + codeLength + '\'' +
                '}';
    }
}
