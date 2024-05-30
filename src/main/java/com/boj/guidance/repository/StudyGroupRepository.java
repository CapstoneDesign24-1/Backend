package com.boj.guidance.repository;

import com.boj.guidance.domain.Member;
import com.boj.guidance.domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, String> {

    @Query("SELECT s " +
            "FROM StudyGroup s " +
            "WHERE s.isDeleted = false ")
    List<StudyGroup> findAllByIsDeletedIsFalse();

    @Query("SELECT m " +
            "FROM Member m " +
            "WHERE (m.weakAlgorithm LIKE %:mainAlgorithm%) AND (m.rating - :rating) <= 100 AND m.state = 'WAITING' " +
            "ORDER BY RAND() LIMIT 3")
    List<Member> findMemberToJoinStudyGroup(@Param("mainAlgorithm") String mainAlgorithm,
                                            @Param("rating") Long rating);
}
