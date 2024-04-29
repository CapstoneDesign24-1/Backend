package com.boj.guidance.repository;

import com.boj.guidance.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    @Query(
            "SELECT m " +
            "FROM Member m " +
            "WHERE m.loginId = :id")
    Optional<Member> findById(@Param("id") String loginId);

    @Query(
            "SELECT m " +
            "FROM Member m " +
            "WHERE m.loginId = :id AND m.loginPassword = :password")
    Optional<Member> findMemberByLoginIdAndLoginPassword(@Param("id") String loginId, @Param("password") String loginPassword);

}
