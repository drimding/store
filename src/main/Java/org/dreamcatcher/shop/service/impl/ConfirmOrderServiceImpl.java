package org.dreamcatcher.shop.service.impl;

import org.dreamcatcher.shop.dao.BasketDAO;
import org.dreamcatcher.shop.dao.CustomUsersDAO;
import org.dreamcatcher.shop.dao.OrdersDAO;
import org.dreamcatcher.shop.entity.Orders;
import org.dreamcatcher.shop.service.ConfirmOrderService;
import org.dreamcatcher.shop.service.UserService;
import org.dreamcatcher.shop.session.CustomSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;


/**
 * Created by dreamcatcher on 18/09/16.
 */
@Service
public class ConfirmOrderServiceImpl implements ConfirmOrderService {
    @Autowired
    UserService userService;
    @Autowired
    CustomSession customSession;
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    CustomUsersDAO customUsersDAO;
    @Autowired
    BasketDAO basketDAO;


    public String confirm(String firstName, String lastName, String email, String password, String address, String city, String phone) {
        System.out.println("star 1 confirm");
        if (firstName != "" && lastName != "" && email != "" && address != "" && phone != "") {
            System.out.println("star 2 confirm");
            System.out.println();
            if (customSession.getAuthentication()
                    instanceof AnonymousAuthenticationToken) {
                System.out.println("star 3 confirm create new user");
                userService.createNewUser(firstName, lastName, email, "", address, city, phone, "USER");

            }
            Orders orders = new Orders();
            orders.setCustomUser(customUsersDAO.findLoginByEmail(customSession.getAuthentication().getName()));
            orders.setVerification(false);
            orders.setImplementation(false);
            orders.setDateTime(LocalDateTime.now());
            ordersDAO.saveAndFlush(orders);
            ordersDAO.createOrder(orders, customSession.getRequestAttributes().getSessionId());
            basketDAO.clearBasketBySessionId(customSession.getRequestAttributes().getSessionId());
        }

        return "";
    }
}
