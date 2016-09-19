package org.dreamcatcher.shop.service;


import org.dreamcatcher.shop.entity.Basket;

import java.util.List;

/**
 * Created by dreamcatcher on 16/09/16.
 */
public interface BasketService {
    Integer getCountItemsBySessinId();

    void setBasketItem(String productId);

    List<Basket> getItemsBySessionId();

    void deleteBasketItem (String busketItemId);

    void updateQuantityInBasket(String basketItemId, String quantity);

}
