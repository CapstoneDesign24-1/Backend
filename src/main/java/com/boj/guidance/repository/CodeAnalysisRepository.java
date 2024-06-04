package com.boj.guidance.repository;

import com.boj.guidance.domain.CodeAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeAnalysisRepository extends JpaRepository<CodeAnalysis, Long> {
    List<CodeAnalysis> findByUserName(String userName);

    Optional<CodeAnalysis> findById(String id);

    List<CodeAnalysis> findByUserNameAndSubmitIdContaining(String userName, String submitId);
    List<CodeAnalysis> findByUserNameAndProblemIdContaining(String userName, String problemId);
    List<CodeAnalysis> findByUserNameAndProblemTitleContaining(String userName, String problemTitle);
}
