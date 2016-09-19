package org.dreamcatcher.shop.service.impl;

import org.dreamcatcher.shop.service.ConfirmOrderService;
import org.dreamcatcher.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dreamcatcher on 18/09/16.
 */
@Service
public class ConfirmOrderServiceImpl implements ConfirmOrderService {
    @Autowired
    UserService userService;

    public String confirm(String firstName, String lastName, String email, String password, String address, String city, String phone) {
        System.out.println("star 1 confirm");
        if (firstName != "" && lastName != "" && email != "" && address != "" && phone != "") {
            System.out.println("star 2 confirm");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.getName().equals("guest")) {
                System.out.println("star 3 confirm");
                userService.createNewUser(firstName, lastName, email, "", address, city, phone, "USER");

            }
        }

        return "";
    }
}
