package org.dreamcatcher.shop.service.impl;
import org.dreamcatcher.shop.dao.BasketDAO;
import org.dreamcatcher.shop.dao.ProductsDAO;
import org.dreamcatcher.shop.entity.Basket;
import org.dreamcatcher.shop.service.BasketService;
import org.dreamcatcher.shop.session.CustomSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

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
        System.out.println(RequestContextHolder.currentRequestAttributes().getSessionId());
        String sessionID = null;
        try{
         sessionID = customSession.getRequestAttributes().getSessionId();
        }catch (NullPointerException e){
            System.out.println(e);
        }
        return basketDAO.findCountItemsBySessinId(sessionID);
    }

    @Transactional
    public void setBasketItem(String productId) {

        try{

                Basket basket = new Basket();
                basket.setProduct(productsDAO.findProductById(Integer.parseInt(productId)));
                basket.setSessionId(customSession.getRequestAttributes().getSessionId());
                basket.setQuantity(1);
                basketDAO.saveAndFlush(basket);

        }catch (NumberFormatException e){
            System.out.println(e);
        }


    }

    public List<Basket> getItemsBySessionId() {
        String sessionID = customSession.getRequestAttributes().getSessionId();
         if(sessionID==null)
            return null;

            return basketDAO.findAllItemsBySessionId(sessionID);
    }

    public void deleteBasketItem(String busketItemId) {
        try {
                 basketDAO.deleteItemInBasket(customSession.getRequestAttributes().getSessionId(), Integer.parseInt(busketItemId));
        }catch (NumberFormatException e){
            System.out.println(e);
        }

    }

    public void updateQuantityInBasket(String basketItemId, String quantity) {
        try {
            int quantityInt = Integer.parseInt(quantity);
            if(quantityInt>0)
            basketDAO.updateQuantityInBasket(quantityInt, Integer.parseInt(basketItemId), customSession.getRequestAttributes().getSessionId());
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }


}
