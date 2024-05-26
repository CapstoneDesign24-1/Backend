package com.boj.guidance.repository;

import com.boj.guidance.domain.Member;
import com.boj.guidance.domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, String> {
    List<StudyGroup> findAllByDeletedIsFalse();

    // TODO: 쿼리 완성
    @Query("SELECT * FROM Member WHERE ")
    List<Member> findMemberByWeakAlgorithm_AAndDeletedIsFalse();
}
