package com.tt.sapp.domain.member.repository;

import com.tt.sapp.domain.member.entity.Member;
import com.tt.sapp.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
