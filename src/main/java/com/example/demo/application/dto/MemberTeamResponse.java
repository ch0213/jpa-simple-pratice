package com.example.demo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor(access = PROTECTED)
public class MemberTeamResponse {

    private String teamName;
    private String memberName;

    public static MemberTeamResponse of(String teamName, String memberName) {
        return new MemberTeamResponse(teamName, memberName);
    }
}
