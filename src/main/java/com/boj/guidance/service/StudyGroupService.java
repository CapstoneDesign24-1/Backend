package com.boj.guidance.service;

import com.boj.guidance.domain.StudyGroup;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupGenerateRequestDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupResponseDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupsResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StudyGroupService {

    @Transactional(readOnly = true)
    StudyGroupsResponseDto findAllGroups();

    @Transactional
    StudyGroupResponseDto createGroup(String memberId, StudyGroupGenerateRequestDto dto);

    @Transactional
    StudyGroupResponseDto deleteGroup(String groupId);

    void memberJoin(String memberId, StudyGroup studyGroup);

    @Transactional
    StudyGroupResponseDto memberExit(String memberId, String groupId);

    @Transactional
    StudyGroupResponseDto recruitMember(String groupId);

    @Transactional
    StudyGroupResponseDto problemSolved(String groupId, Integer problemId);

    @Transactional(readOnly = true)
    Optional<StudyGroupResponseDto> checkIfMemberJoined(String memberId);
}
