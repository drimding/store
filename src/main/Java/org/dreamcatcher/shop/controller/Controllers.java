package org.dreamcatcher.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dreamcatcher on 08.09.16.
 */
@Controller
public class Controllers {
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
