package com.example.demo.domain.memberteam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberTeamCustomRepository {
    Page<MemberTeam> findAllTeam(Pageable pageable);
}
