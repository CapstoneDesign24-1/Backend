package com.boj.guidance.repository;

import com.boj.guidance.domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, String> {
    List<StudyGroup> findAllByIsDeletedIsFalse();

    // TODO: 쿼리 완성
//    List<Member> findMemberByWeakAlgorithm_AAndDeletedIsFalse();
}
