package com.tt.sapp.domain.member.dto;

import com.tt.sapp.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private final Long id;
    private final String username;
    private final String password;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.password = member.getPassword();
    }
}
