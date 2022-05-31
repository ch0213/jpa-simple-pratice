package com.example.demo.application;

import com.example.demo.application.dto.MemberTeamResponse;
import com.example.demo.domain.memberteam.MemberTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final MemberTeamRepository memberTeamRepository;

    @Transactional
    public Page<MemberTeamResponse> findAllTeam(Pageable pageable) {
        return memberTeamRepository.findAllTeam(pageable)
                .map(memberTeam -> MemberTeamResponse.of(memberTeam.teamName(), memberTeam.memberName()));
    }
}
