package com.boj.guidance.dto.StudyGroupDto;

import com.boj.guidance.domain.Member;
import com.boj.guidance.domain.Problem;
import com.boj.guidance.domain.StudyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class StudyGroupResponseDto {
    private String id;
    private String propose;
    private List<Member> memberList;
    private List<Problem> solvedList;
    private boolean isDeleted;

    @Builder
    public StudyGroupResponseDto(
            String id,
            String propose,
            List<Member> memberList,
            List<Problem> solvedList,
            boolean isDeleted
    ) {
        this.id = id;
        this.propose = propose;
        this.memberList = memberList;
        this.solvedList = solvedList;
        this.isDeleted = isDeleted;
    }

    public StudyGroupResponseDto toResponse(StudyGroup entity) {
        return StudyGroupResponseDto.builder()
                .id(entity.getId())
                .propose(entity.getPropose())
                .memberList(entity.getMemberList())
                .solvedList(entity.getSolvedList())
                .isDeleted(entity.isDeleted())
                .build();
    }
}
