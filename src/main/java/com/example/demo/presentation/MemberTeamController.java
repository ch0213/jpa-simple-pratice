package com.example.demo.presentation;

import com.example.demo.application.MemberTeamService;
import com.example.demo.application.dto.MemberTeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberTeamController {

    private final MemberTeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<Page<MemberTeamResponse>> findTeams(Pageable pageable) {
        return ResponseEntity.ok(teamService.findAllTeam(pageable));
    }
}
