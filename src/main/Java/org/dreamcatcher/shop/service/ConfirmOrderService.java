package org.dreamcatcher.shop.service;

/**
 * Created by dreamcatcher on 18/09/16.
 */
public interface ConfirmOrderService {
    String confirm(String firstName, String lastName, String email, String password, String address, String city, String phone);
}