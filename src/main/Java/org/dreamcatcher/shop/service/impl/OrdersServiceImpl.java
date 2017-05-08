package org.dreamcatcher.shop.service.impl;

import org.dreamcatcher.shop.dao.BasketDAO;
import org.dreamcatcher.shop.dao.OrdersDAO;
import org.dreamcatcher.shop.entity.Basket;
import org.dreamcatcher.shop.entity.Orders;
import org.dreamcatcher.shop.entity.OrdersDetail;
import org.dreamcatcher.shop.service.OrdersService;
import org.dreamcatcher.shop.session.CustomSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dreamcatcher on 18/09/16.
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    CustomSession customSession;
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    BasketDAO basketDAO;
    @Transactional
    public void createOrder() {
        List<Basket> basketItems = basketDAO.findAllItemsBySessionId(customSession.getRequestAttributes().getSessionId());

    }

    public List<OrdersDetail> getOrdersByUserId() {
        return ordersDAO.findOrdersByUserlogin(customSession.getAuthentication().getName());
    }


}
