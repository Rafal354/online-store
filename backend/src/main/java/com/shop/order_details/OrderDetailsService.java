package com.shop.order_details;

import com.shop.order_details.repository.OrderDetailsRepository;

public class OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
}
