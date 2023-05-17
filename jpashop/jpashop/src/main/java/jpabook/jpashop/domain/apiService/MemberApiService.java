package jpabook.jpashop.domain.apiService;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.dto.MemberRequest;
import jpabook.jpashop.domain.dto.MemberResponse;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberApiService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse join(MemberRequest memberRequest){
        Member member = memberRequest.toMember();

        Member save = memberRepository.save(member);

        return new MemberResponse(save);
    }

    public MemberResponse memberDetail(Long id){
        return new MemberResponse(memberRepository.findById(id).orElseThrow());
    }
}
