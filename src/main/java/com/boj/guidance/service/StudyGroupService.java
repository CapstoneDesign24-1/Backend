package com.boj.guidance.service;

import com.boj.guidance.dto.StudyGroupDto.StudyGroupGenerateRequestDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupResponseDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupsResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface StudyGroupService {

    @Transactional(readOnly = true)
    StudyGroupsResponseDto findAllGroups();

    @Transactional
    StudyGroupResponseDto createGroup(String memberId, StudyGroupGenerateRequestDto dto);

    @Transactional
    StudyGroupResponseDto deleteGroup(String groupId);

    StudyGroupResponseDto memberJoin(String memberId, String groupId);

    @Transactional
    StudyGroupResponseDto memberExit(String memberId, String groupId);

    @Transactional
    StudyGroupResponseDto recruitMember(String groupId);

    @Transactional
    StudyGroupResponseDto problemSolved(String groupId, Integer problemId);
}
