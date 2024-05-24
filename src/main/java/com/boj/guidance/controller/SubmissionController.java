// src/main/java/com/boj/guidance/controller/SubmissionController.java
package com.boj.guidance.controller;

import com.boj.guidance.domain.Submission;
import com.boj.guidance.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/myapp/data")
@CrossOrigin(origins = {"https://www.acmicpc.net", "chrome-extension://<extension-id>"}) // 허용할 도메인 설정
public class SubmissionController {

    private static final Logger logger = LoggerFactory.getLogger(SubmissionController.class);

    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public Submission receiveSubmission(@RequestBody Submission submission) {
        // 로그에 받은 데이터를 출력
        logger.info("Received Submission: {}", submission);

        return submissionService.saveSubmission(submission);
    }
}
