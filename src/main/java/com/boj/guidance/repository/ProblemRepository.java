package com.boj.guidance.repository;

import com.boj.guidance.domain.Problem;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    // 문제 id로 문제의 알고리즘 목록 검색
    @Query(value =
            "SELECT name " +
            "FROM algorithm " +
            "WHERE problem_id = :id", nativeQuery = true)
    List<String> findAlgorithmsById(@Param("id") Integer id);

    @Query(value =
            "SELECT problem_id " +
            "FROM algorithm " +
            "WHERE name = :name", nativeQuery = true
    )
    List<Integer> findAllProblemIds(String name);

}
