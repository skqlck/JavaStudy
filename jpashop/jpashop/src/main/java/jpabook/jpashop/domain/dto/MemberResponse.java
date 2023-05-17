package jpabook.jpashop.domain.dto;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberResponse {

    private Long id;
    private String name;
    private Address address;

    private List<Order> orders = new ArrayList<>();

    public MemberResponse(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.address = member.getAddress();
        this.orders = member.getOrders();
    }
}
