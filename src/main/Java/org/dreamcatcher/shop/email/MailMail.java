package org.dreamcatcher.shop.email;

/**
 * Created by dreamcatcher on 18/09/16.
 */
public interface MailMail {
    void sendMail(String to, String subject, String msg);
}
