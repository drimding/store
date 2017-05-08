package org.dreamcatcher.shop.service;

import org.dreamcatcher.shop.entity.CustomUser;
import org.dreamcatcher.shop.enums.Errors;

/**
 * Created by dreamcatcher on 18/09/16.
 */
public interface UserService {
    Errors createNewUser (String firstName, String lastName, String email, String password, String address, String city, String phone, String permission);
    CustomUser getCurrentUser();
}
