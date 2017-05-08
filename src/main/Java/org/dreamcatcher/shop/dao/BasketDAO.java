package org.dreamcatcher.shop.dao;

import org.dreamcatcher.shop.entity.Basket;
import org.dreamcatcher.shop.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dreamcatcher on 16/09/16.
 */
public interface BasketDAO extends JpaRepository <Basket, Integer>{

    @Query("SELECT COUNT(b) FROM Basket b WHERE b.sessionId=?1")
    int findCountItemsBySessinId(String sessionId);

    @Transactional
    @Query("SELECT b FROM Basket b JOIN FETCH b.product pr JOIN FETCH pr.productCategory WHERE b.sessionId=?1")
    List<Basket> findAllItemsBySessionId(String SessionId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Basket b WHERE b.sessionId=?1 AND b.id=?2")
    void deleteItemInBasket(String sessionId, int id);

    @Modifying
    @Transactional
    @Query("UPDATE Basket b SET b.quantity=?1 WHERE b.id=?2 AND b.sessionId=?3")
    void updateQuantityInBasket (int quantity, int id, String sessionId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Basket b WHERE b.sessionId=?1")
    void clearBasketBySessionId(String sessionID);
}
