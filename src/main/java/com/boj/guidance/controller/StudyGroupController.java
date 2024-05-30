package com.boj.guidance.controller;

import com.boj.guidance.dto.StudyGroupDto.StudyGroupGenerateRequestDto;
import com.boj.guidance.dto.StudyGroupDto.StudyGroupResponseDto;
import com.boj.guidance.service.StudyGroupService;
import com.boj.guidance.util.api.ApiResponse;
import com.boj.guidance.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    @PostMapping("/create/{memberId}")
    public ApiResponse<StudyGroupResponseDto> createGroup(@PathVariable("memberId") String memberId,
                                                          @RequestBody StudyGroupGenerateRequestDto dto) {
        return ApiResponse.success(ResponseCode.STUDY_GROUP_CREATE_SUCCESS.getMessage(), studyGroupService.createGroup(memberId, dto));
    }

    @PutMapping("/recruit/{groupId}")
    public ApiResponse<StudyGroupResponseDto> recruit(@PathVariable("groupId") String groupId) {
        return ApiResponse.success(ResponseCode.STUDY_GROUP_RECRUIT_SUCCESS.getMessage(), studyGroupService.recruitMember(groupId));
    }

}
