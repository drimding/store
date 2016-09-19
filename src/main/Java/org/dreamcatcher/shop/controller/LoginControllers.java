package org.dreamcatcher.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dreamcatcher on 18/09/16.
 */
@Controller
public class LoginControllers {

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginPage() {
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "redirect:/";
    }

    @RequestMapping(value = "/loginfail", method = RequestMethod.GET)
    public String loginfail() {
        return "redirect:/";
    }

}
