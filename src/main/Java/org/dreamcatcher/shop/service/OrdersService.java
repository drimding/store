package org.dreamcatcher.shop.service;

import org.dreamcatcher.shop.entity.Orders;
import org.dreamcatcher.shop.entity.OrdersDetail;

import java.util.List;

/**
 * Created by dreamcatcher on 18/09/16.
 */
public interface OrdersService {
    void createOrder();
    List<OrdersDetail>  getOrdersByUserId();
}
