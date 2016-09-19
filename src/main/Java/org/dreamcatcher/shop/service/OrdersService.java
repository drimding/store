package org.dreamcatcher.shop.service;

import java.util.List;

/**
 * Created by dreamcatcher on 18/09/16.
 */
public interface OrdersService {
    void createOrder();
    List<OrdersService>  getAllOrders();
}
