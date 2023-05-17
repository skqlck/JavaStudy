package jpabook.jpashop.domain.dto;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequest {

    private String name;

    private Address address;

    private List<Order> orders = new ArrayList<>();

    public Member toMember(){
        return Member.builder().
                name(this.name)
                .address(this.address)
                .orders(this.orders)
                .build();
    }
}
