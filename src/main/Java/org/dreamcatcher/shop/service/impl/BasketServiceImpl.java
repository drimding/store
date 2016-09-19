package org.dreamcatcher.shop.service.impl;
import org.dreamcatcher.shop.dao.BasketDAO;
import org.dreamcatcher.shop.dao.ProductsDAO;
import org.dreamcatcher.shop.entity.Basket;
import org.dreamcatcher.shop.service.BasketService;
import org.dreamcatcher.shop.session.CustomSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dreamcatcher on 16/09/16.
 */
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketDAO basketDAO;
    @Autowired
    ProductsDAO productsDAO;
    @Autowired
    CustomSession customSession;


    public Integer getCountItemsBySessinId() {
        return basketDAO.findCountItemsBySessinId(customSession.getSessionID());
    }

    @Transactional
    public void setBasketItem(String productId) {

        try{

                basketDAO.insertItemInBasket(productsDAO.findProductById(Integer.parseInt(productId)), customSession.getSessionID(), 1);

        }catch (NumberFormatException e){
            System.out.println(e);
        }


    }

    public List<Basket> getItemsBySessionId() {

            return basketDAO.findAllItemsBySessionId(customSession.getSessionID());
    }

    public void deleteBasketItem(String busketItemId) {
        try {
            basketDAO.deleteItemInBasket(customSession.getSessionID(), Integer.parseInt(busketItemId));
        }catch (NumberFormatException e){
            System.out.println(e);
        }

    }

    public void updateQuantityInBasket(String basketItemId, String quantity) {
        try {
            int quantityInt = Integer.parseInt(quantity);
            if(quantityInt>0)
            basketDAO.updateQuantityInBasket(quantityInt, Integer.parseInt(basketItemId), customSession.getSessionID());
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }


}
