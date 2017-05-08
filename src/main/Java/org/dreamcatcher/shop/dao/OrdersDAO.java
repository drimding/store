package org.dreamcatcher.shop.dao;

import org.dreamcatcher.shop.entity.Orders;
import org.dreamcatcher.shop.entity.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dreamcatcher on 19/09/16.
 */
public interface OrdersDAO extends JpaRepository <Orders, Integer>{

    @Query("FROM OrdersDetail od JOIN fetch od.orders o JOIN fetch o.customUser cu JOIN fetch od.product WHERE cu.email=?1")
    List<OrdersDetail> findOrdersByUserlogin(String email);

    @Modifying
    @Transactional
    @Query("INSERT INTO  OrdersDetail (quantity, priceUSD, product, orders ) SELECT b.quantity, b.product.priceUSD, b.product, ?1 FROM Basket b where b.sessionId=?2")
    void createOrder (Orders orders, String sessionId);
}
