package org.dreamcatcher.shop.dao;

import org.dreamcatcher.shop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dreamcatcher on 19/09/16.
 */
public interface OrdersDAO extends JpaRepository <Orders, Integer>{
}
