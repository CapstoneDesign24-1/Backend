package com.boj.guidance.dto.StudyGroupDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class StudyGroupsResponseDto {
    private List<StudyGroupResponseDto> studyGroupList;
    private int count;

    @Builder
    public StudyGroupsResponseDto(
            List<StudyGroupResponseDto> studyGroupList,
            int count
    ) {
        this.studyGroupList = studyGroupList;
        this.count = count;
    }

    public StudyGroupsResponseDto toArray(
            List<StudyGroupResponseDto> studyGroupList,
            int count
    ) {
        return StudyGroupsResponseDto.builder()
                .studyGroupList(studyGroupList)
                .count(count)
                .build();
    }
}
