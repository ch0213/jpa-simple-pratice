package com.example.demo.domain.memberteam;

import com.example.demo.domain.member.QMember;
import com.example.demo.domain.team.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.example.demo.domain.member.QMember.member;
import static com.example.demo.domain.memberteam.QMemberTeam.memberTeam;
import static com.example.demo.domain.team.QTeam.team;

@RequiredArgsConstructor
public class MemberTeamRepositoryImpl implements MemberTeamCustomRepository {

    private final JPAQueryFactory factory;

    @Override
    public Page<MemberTeam> findAllTeam(Pageable pageable) {
        List<MemberTeam> memberTeams = factory.selectFrom(memberTeam)
                .join(memberTeam.member, member)
                .fetchJoin()
                .join(memberTeam.team, team)
                .fetchJoin()
                .orderBy(memberTeam.team.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return PageableExecutionUtils.getPage(memberTeams, pageable, memberTeams::size);
    }
}
