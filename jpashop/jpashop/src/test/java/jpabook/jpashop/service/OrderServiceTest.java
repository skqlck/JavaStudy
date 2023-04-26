package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired ItemRepository itemRepository;

    @Test
    void order(){
        //Given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10000, 10);
        int orderCount = 2;

        //When
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        //Then
        Order getOrder = orderRepository.findById(orderId).get();
        // 상품 주문시 상태는 ORDER
        assertEquals(OrderStatus.ORDER, getOrder.getStatus());
        // 주문한 상품 종류 수가 정확해야 한다.
        assertEquals(1, getOrder.getOrderItems().size());
        // 주문 가격은 가격 * 수량이다.
        assertEquals(10000*2, getOrder.getTotalPrice());
        // 주문 수량만큼 재고가 줄어야한다.
        assertEquals(8, item.getStockQuantity());
    }

    @Test
    void cancelOrder() {
        //Given
        Member member = createMember();
        Item item1 = createBook("시골 JAP", 10000, 10);
        Item item2 = createBook("도시 JAP", 10000, 5);
        int orderCount = 2;

        //When
        Long orderId1 = orderService.order(member.getId(), item1.getId(), orderCount);
        Long orderId2 = orderService.order(member.getId(), item2.getId(), orderCount);

        //Then
        Order getOrder1 = orderRepository.findById(orderId1).get();
        Order getOrder2 = orderRepository.findById(orderId2).get();

        // 배송완료 상태로 만들기
        getOrder2.getDelivery().setStatus(DeliveryStatus.COMP);

        getOrder1.cancel();

        // 배송 완료된 주문은 취소가 불가능하다.
        assertThrows(IllegalStateException.class, () -> {getOrder2.cancel();});

        // 주문 취소한 주문의 상태는 CANCEL
        assertEquals(OrderStatus.CANCEL, getOrder1.getStatus());

        // 주문 취소하면 재고가 다시 늘어나야한다.
        assertEquals(10, item1.getStockQuantity());

    }

    @Test
    public void stockQuantityOver(){
        //Given
        Member member = createMember();
        Item item = createBook("시골 JAP", 10000, 10);
        int orderCount = 11; // 재고보다 많은 수량 주문

        //When
        orderService.order(member.getId(), item.getId(), orderCount);

        //Then
        fail("재고 수량 부족 예외가 발생해야 한다.");
    }


    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강가","123-123"));
        memberRepository.save(member);
        return member;
    }
    private Book createBook(String name, int price, int stockQuantity){
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        itemRepository.save(book);
        return book;
    }
}