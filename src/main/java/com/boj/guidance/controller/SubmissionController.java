package com.boj.guidance.controller;

import com.boj.guidance.domain.CodeAnalysis;
import com.boj.guidance.dto.SubmissionDto.SubmissionReceiveRequestDto;
import com.boj.guidance.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myapp")
@RequiredArgsConstructor
@CrossOrigin(origins = {"*"}) // 허용할 도메인 설정
@Slf4j
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/data")
    public ResponseEntity<CodeAnalysis> receiveSubmission(@RequestBody SubmissionReceiveRequestDto dto) {
        CodeAnalysis codeAnalysis = submissionService.saveSubmission(dto);
        return ResponseEntity.ok(codeAnalysis);
    }
}
