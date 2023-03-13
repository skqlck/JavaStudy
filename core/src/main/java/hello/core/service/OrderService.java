package hello.core.service;

import hello.core.Order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itmePrice);
}
