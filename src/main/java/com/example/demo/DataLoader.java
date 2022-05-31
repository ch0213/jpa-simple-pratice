package com.example.demo;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberRepository;
import com.example.demo.domain.memberteam.MemberTeam;
import com.example.demo.domain.memberteam.MemberTeamRepository;
import com.example.demo.domain.team.Team;
import com.example.demo.domain.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final MemberTeamRepository memberTeamRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostConstruct
    public void uploadData() {
        init();
    }

    @Transactional
    public void init() {
        Member 철수 = memberRepository.save(new Member("철수"));
        Member 영희 = memberRepository.save(new Member("영희"));
        Member 짱구 = memberRepository.save(new Member("짱구"));
        Member 훈이 = memberRepository.save(new Member("훈이"));

        Team team1 = teamRepository.save(new Team("team1"));
        Team team2 = teamRepository.save(new Team("team2"));
        Team team3 = teamRepository.save(new Team("team3"));
        Team team4 = teamRepository.save(new Team("team4"));

        memberTeamRepository.save(new MemberTeam(철수, team1));
        memberTeamRepository.save(new MemberTeam(철수, team2));
        memberTeamRepository.save(new MemberTeam(철수, team3));
        memberTeamRepository.save(new MemberTeam(영희, team4));
        memberTeamRepository.save(new MemberTeam(영희, team1));
        memberTeamRepository.save(new MemberTeam(짱구, team2));
        memberTeamRepository.save(new MemberTeam(짱구, team4));
        memberTeamRepository.save(new MemberTeam(훈이, team1));
        memberTeamRepository.save(new MemberTeam(훈이, team4));
    }
}
