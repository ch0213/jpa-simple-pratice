package com.example.demo.domain.memberteam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTeamRepository extends JpaRepository<MemberTeam, Long>, MemberTeamCustomRepository {
}
