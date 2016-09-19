package org.dreamcatcher.shop.email.impl;

import org.dreamcatcher.shop.email.MailMail;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by dreamcatcher on 18/09/16.
 */
@Service
public class MailMailImpl implements MailMail {

    @Autowired
    JavaMailSender mailSender;



    public void sendMail(String to, String subject, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        /*message.setFrom(from);*/
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

}