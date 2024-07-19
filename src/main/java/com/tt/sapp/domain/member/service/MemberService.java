package com.tt.sapp.domain.member.service;

import com.tt.sapp.domain.member.entity.Member;
import com.tt.sapp.domain.member.repository.MemberRepository;
import com.tt.sapp.domain.post.post.entity.Post;
import com.tt.sapp.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create(String username, String password) {
        Member member = Member.builder().username(username).password(password).build();
        return memberRepository.save(member);
    }

    public Member login(String username, String password) {
        Optional<Member> result = memberRepository.findByUsername(username);

        if (result.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }

        if(!result.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return result.get();
    }
}
