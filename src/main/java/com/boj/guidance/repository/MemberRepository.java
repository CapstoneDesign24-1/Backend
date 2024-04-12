package com.boj.guidance.repository;

import com.boj.guidance.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

    @Override
    Optional<Member> findById(UUID uuid);

    @Query("select m " +
            "from Member m " +
            "where m.login_id = :id and m.login_password = :password")
    Optional<Member> findMemberByLogin_idAndLogin_password(@Param("id") String login_id, @Param("password") String login_password);

}
