package hello.core.service;

import hello.core.Order.Order;
import hello.core.domain.Grade;
import hello.core.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    @DisplayName("가격비교")
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        MemberService memberService = new MemberServiceImpl();
        memberService.join(member);
        OrderService orderService = new OrderServiceImpl();

        Order order = orderService.createOrder(memberId,"chicken",10000);

        org.assertj.core.api.Assertions.assertThat(order.getDiscountPrice()).isEqualTo(500);

    }
}