package hello.core.service;

import hello.core.domain.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //테스트 용도 ( 스프링 빈에서 서로 다른 메서드에서 같은 값을 인스턴스를 반환할 때 어떻게 싱글톤이 안깨지는지)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
