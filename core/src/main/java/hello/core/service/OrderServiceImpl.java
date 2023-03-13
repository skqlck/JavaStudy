package hello.core.service;

import hello.core.Order.Order;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.domain.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member =memberRepository.findById(memberId);
        int discountPrie = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrie);
    }
}
