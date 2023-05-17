package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Array;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue
    @Column(name="memeber_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
