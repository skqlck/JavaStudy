package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.validation.MemberForm;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestMemberController {
    private final MemberRepository memberRepository;
    @GetMapping(value="/showMembers")
    public List<Member> showMembers(){

        List<Member> all = memberRepository.findAll();

        return all;
    }

    @PostMapping(value="/joinMember")
    public void joinMember(@RequestBody MemberForm memberForm){

        Member member = new Member();

        member.setName(memberForm.getName());

        memberRepository.save(member);
    }

}
