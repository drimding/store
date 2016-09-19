package org.dreamcatcher.shop.service.impl;




import org.apache.commons.lang3.RandomStringUtils;
import org.dreamcatcher.shop.dao.CustomUsersDAO;
import org.dreamcatcher.shop.email.MailMail;
import org.dreamcatcher.shop.entity.CustomUser;
import org.dreamcatcher.shop.enums.Errors;
import org.dreamcatcher.shop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * Created by dreamcatcher on 18/09/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    CustomUsersDAO customUsersDAO;

    @Autowired
    MailMail mailMail;


    public Errors createNewUser(String firstName, String lastName, String email, String password, String address, String city, String phone, String permission) {
        if (firstName != "" && lastName != "" && email != "" && address != "" && phone != "") {
            System.out.println("star 1 user");
            if (password == "") {
                password = RandomStringUtils.randomAlphanumeric(5);
           }
           try {
               System.out.println("star 2 user");
               customUsersDAO.saveAndFlush(new CustomUser(firstName, lastName, email, address, permission, city, password, phone));
           }catch (DataIntegrityViolationException e){
               System.out.println(e);
               return Errors.DUPLICATE_USER;
          }
            System.out.println("star 3 user");
          mailMail.sendMail(email, "Реєстрація на TechShop",
                  "Ви одержали це повідомлення оскільки були зареєстровані на сайті TechShop\n" +
                          "Login: "+email+"\nPassword: "+password+"\n" +
                          "З допомогою даного логіна і пароля, ви завжди зможете переглянути історію замовлень");

        }
        return Errors.ok;
    }

}
