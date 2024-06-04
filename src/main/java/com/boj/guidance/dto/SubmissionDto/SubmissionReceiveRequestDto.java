package com.boj.guidance.dto.SubmissionDto;

import com.boj.guidance.domain.Submission;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SubmissionReceiveRequestDto {
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

    public Submission toEntity(){
        return Submission.builder()
                .codeContent(codeContent)
                .userName(userName)
                .submitId(submitId)
                .userId(userId)
                .problemId(problemId)
                .problemTitle(problemTitle)
                .result(result)
                .memory(memory)
                .time(time)
                .language(language)
                .codeLength(codeLength)
                .build();
    }
}

