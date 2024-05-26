package com.boj.guidance.domain;

import com.boj.guidance.util.annotation.LockSerial;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class StudyGroup {

    @Id
    @LockSerial
    private String id;
    private String propose;             // 스터디그룹 공동 목표
    @OneToMany(mappedBy = "studyGroup")
    private List<Member> memberList;    // 스터디 부원 list
    @ManyToMany
    private List<Problem> solvedList;   // 스터디 부원들이 함께 푼 문제 list
    @Setter
    private boolean isDeleted;          // 삭제 여부

    @Builder
    public StudyGroup(
            String propose
    ) {
        this.propose = propose;
        this.memberList = new ArrayList<>();
        this.solvedList = new ArrayList<>();
        this.isDeleted = false;
    }

    public void addMember(Member member) {
        this.memberList.add(member);
    }

    public void removeMember(Member member) {
        this.memberList.remove(member);
    }

    public void addProblem(Problem problem) {
        this.solvedList.add(problem);
    }

}
