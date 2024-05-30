package com.boj.guidance.dto.StudyGroupDto;

import com.boj.guidance.domain.Member;
import com.boj.guidance.domain.Problem;
import com.boj.guidance.domain.StudyGroup;
import com.boj.guidance.dto.MemberDto.MemberStudyGroupResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class StudyGroupResponseDto {
    private String id;
    private String propose;
    private List<MemberStudyGroupResponseDto> memberList;
    private List<Problem> solvedList;
    private boolean isDeleted;
    private Long avgRating;
    private String mainAlgorithm;

    @Builder
    public StudyGroupResponseDto(
            String id,
            String propose,
            List<Member> memberList,
            List<Problem> solvedList,
            boolean isDeleted,
            Long avgRating,
            String mainAlgorithm
    ) {
        this.id = id;
        this.propose = propose;
        this.memberList = memberList.stream()
                .map(member -> new MemberStudyGroupResponseDto().toResponse(member))
                .collect(Collectors.toList());
        this.solvedList = solvedList;
        this.isDeleted = isDeleted;
        this.avgRating = avgRating;
        this.mainAlgorithm = mainAlgorithm;
    }

    public StudyGroupResponseDto toResponse(StudyGroup entity) {
        return StudyGroupResponseDto.builder()
                .id(entity.getId())
                .propose(entity.getPropose())
                .memberList(entity.getMemberList())
                .solvedList(entity.getSolvedList())
                .isDeleted(entity.isDeleted())
                .avgRating(entity.getAvgRating())
                .mainAlgorithm(entity.getMainAlgorithm())
                .build();
    }
}
