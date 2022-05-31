package com.example.demo.domain.member;

import com.example.demo.domain.memberteam.MemberTeam;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<MemberTeam> memberTeams = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }
}
