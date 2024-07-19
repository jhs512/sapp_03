package com.tt.sapp.domain.member.controller;

import com.tt.sapp.domain.member.dto.MemberDto;
import com.tt.sapp.domain.member.entity.Member;
import com.tt.sapp.domain.member.service.MemberService;
import com.tt.sapp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    public record MemberJoinRequestBody(String username, String password) {
    }

    @PostMapping("/join")
    public RsData<MemberDto> join(@RequestBody MemberJoinRequestBody requestBody) {
        Member member = memberService.create(requestBody.username(), requestBody.password());
        return new RsData<>(new MemberDto(member));
    }


    public record MemberLoginRequestBody(String username, String password) {
    }

    public record MemberLoginResponseBody(long id, String username) {
    }
    @PostMapping("/login")
    public RsData<MemberLoginResponseBody> login(@RequestBody MemberLoginRequestBody requestBody) {
        Member member = memberService.login(requestBody.username(), requestBody.password());
        return new RsData<>(new MemberLoginResponseBody(member.getId(), member.getUsername()));
    }
}
