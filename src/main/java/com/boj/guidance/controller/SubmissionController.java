// src/main/java/com/boj/guidance/controller/SubmissionController.java
package com.boj.guidance.controller;

import com.boj.guidance.domain.Submission;
import com.boj.guidance.dto.SubmissionDto.SubmissionReceiveRequestDto;
import com.boj.guidance.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/myapp/data")
@CrossOrigin(origins = {"*"}) // 허용할 도메인 설정
public class SubmissionController {


    private final SubmissionService submissionService;

    @PostMapping
    public Submission receiveSubmission(@RequestBody SubmissionReceiveRequestDto submission) {
        // 로그에 받은 데이터를 출력
        log.info(submission.toString());

        return submissionService.saveSubmission(submission);
    }
}
