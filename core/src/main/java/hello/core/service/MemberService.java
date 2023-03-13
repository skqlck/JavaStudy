package hello.core.service;

import hello.core.domain.Member;

public interface MemberService {

    void join(Member member); //create

    Member findMember(Long memberId);
}
