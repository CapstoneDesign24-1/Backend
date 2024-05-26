package com.boj.guidance.dto.StudyGroupDto;

import com.boj.guidance.domain.StudyGroup;

public class StudyGroupGenerateRequestDto {
    private String propose;     // 스터디그룹의 목표

    public StudyGroup toEntity() {
        return StudyGroup.builder()
                .propose(this.propose)
                .build();
    }
}
