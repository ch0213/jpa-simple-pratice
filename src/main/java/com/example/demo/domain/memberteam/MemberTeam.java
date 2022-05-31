package com.example.demo.domain.memberteam;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.team.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class MemberTeam {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public MemberTeam(Member member, Team team) {
        this.member = member;
        this.team = team;
    }

    public String memberName() {
        return member.getName();
    }

    public String teamName() {
        return team.getName();
    }
}
