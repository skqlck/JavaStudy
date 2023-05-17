package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.apiService.MemberApiService;
import jpabook.jpashop.domain.dto.MemberRequest;
import jpabook.jpashop.domain.dto.MemberResponse;
import jpabook.jpashop.domain.validation.MemberForm;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestMemberController {
    private final MemberRepository memberRepository;
    private final MemberApiService memberApiService;
    @GetMapping(value="/showMembers")
    public List<Member> showMembers(){

        List<Member> all = memberRepository.findAll();

        return all;
    }

    @PostMapping(value="/joinMember")
    public ResponseEntity<MemberResponse> joinMember(@RequestBody MemberRequest memberRequest){
        return ResponseEntity.ok().body(memberApiService.join(memberRequest));
    }

    @GetMapping(value="/member/{id}")
    public ResponseEntity<MemberResponse> memberDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(memberApiService.memberDetail(id));
    }
}
