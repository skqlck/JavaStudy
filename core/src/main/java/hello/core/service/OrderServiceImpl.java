package hello.core.service;

import hello.core.Order.Order;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.domain.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository){
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member =memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
