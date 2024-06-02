package com.boj.guidance.repository;

import com.boj.guidance.domain.CodeAnalysis;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeAnalysisRepository extends JpaRepository<CodeAnalysis, Long> {
    List<CodeAnalysis> findByUserName(String userName);

    Optional<CodeAnalysis> findBySubmitId(String submitId);
    Optional<CodeAnalysis> findById(String id);
}
