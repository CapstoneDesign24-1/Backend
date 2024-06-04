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
public class CodeAnalysis {
    @Id
    @LockSerial(keyPrefix = LockName.MEMBER)
    private String id;
    private String submitId;
    private String userName;
    private String response;
    private String codeContent;
    private String problemId;
    private String problemTitle;
    private String result;
    private String language;
}
