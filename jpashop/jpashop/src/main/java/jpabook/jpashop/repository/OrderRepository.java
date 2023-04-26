package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.StringUtils;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    public List<Order> findAllByString(OrderSearch orderSearch){
//        String jpql = "select o From Order o join o.member m";
//        boolean isFirstCondition = true;
//
//        if (orderSearch.getOrderStatus() != null){
//            if (isFirstCondition){
//                jpql += "where";
//                isFirstCondition = false;
//            }
//            else {
//                jpql += "and";
//            }
//            jpql += " o.status = :status";
//        }
//    }
//
//    if (StringUtils.hasText(orderSearch.getMemberName())){
//        if (isFirstCondition){
//
//        }
//    }
}
