package com.boj.guidance.service;

import com.boj.guidance.dto.StudyGroupDto.StudyGroupGenerateRequestDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupResponseDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupsResponseDto;

public interface StudyGroupService {
    StudyGroupsResponseDto findAllGroups();

    StudyGroupResponseDto createGroup(String memberId, StudyGroupGenerateRequestDto dto);

    StudyGroupResponseDto deleteGroup(String groupId);

    StudyGroupResponseDto memberJoin(String memberId, String groupId);

    StudyGroupResponseDto memberExit(String memberId, String groupId);

    StudyGroupResponseDto recruitMember(String groupId);

    StudyGroupResponseDto problemSolved(String groupId, Integer problemId);
}
