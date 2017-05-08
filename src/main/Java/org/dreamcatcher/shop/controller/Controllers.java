package org.dreamcatcher.shop.controller;

import org.dreamcatcher.shop.service.*;
import org.dreamcatcher.shop.session.CustomSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dreamcatcher on 08.09.16.
 */
@Controller
public class Controllers {
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ProductsService productsService;
    @Autowired
    BasketService basketService;
    @Autowired
    ConfirmOrderService confirmOrderService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    CustomSession customSession;
    @Autowired
    UserService userService;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("ProductCategoru", productCategoryService.getAllProductCategory());
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());

        return "home";
    }

    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping (value = "/getItemsContent", method = RequestMethod.GET)
    public String getItemsContent(@RequestParam String id, Model model){
        model.addAttribute("ProductCategoru", productCategoryService.getAllProductCategory());
        model.addAttribute("Products", productsService.getProductsByProductCategoryId(id));
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        return "home";
    }

    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/add-basketElement", method = RequestMethod.POST)
    public String addElementInbasket(@RequestParam (value = "productId") String  productId,
                                     @RequestHeader(value = "Referer") String  Referer, Model model) throws MalformedURLException {

        URL aURL = new URL(Referer);
        String url = aURL.getQuery();
        String[] id = url.split("=");

        basketService.setBasketItem(productId);
        return "redirect:/getItemsContent?id="+id[1];
    }


    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCheckoutPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        model.addAttribute("busketItems", basketService.getItemsBySessionId());
        return "checkout";
    }

    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping (value = "/delItem-inBasket", method = RequestMethod.POST)
    public  String delItemInBasket(@RequestParam (value = "basketItemId") String busketItemId){
        basketService.deleteBasketItem(busketItemId);
        return "redirect:/checkout";
    }

    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping (value = "/updateQuantity-inBasket", method = RequestMethod.POST)
    public String updateQuantityInBasket(@RequestParam (value = "basketItemId") String basketItemId,
                                         @RequestParam(value = "quantity") String quantity){

        basketService.updateQuantityInBasket(basketItemId, quantity);
        return "redirect:/checkout";
    }

    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public  String confirmPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        model.addAttribute("currentUser", userService.getCurrentUser());


        return "confirm";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public  String showOrderPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        model.addAttribute("orders", ordersService.getOrdersByUserId());
        return "orders";
    }

    @Secured({"ROLE_ANONYMOUS","ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/confirmOrderNewUser", method = RequestMethod.POST)
    public  String confirmOrderNewUser (@RequestParam(value = "firstName") String firstName,
                                        @RequestParam(value = "lastName") String lastName,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "address") String address,
                                        @RequestParam(value = "city") String city,
                                        @RequestParam(value = "phone") String phone, Model model){

        model.addAttribute("Error", confirmOrderService.confirm(firstName, lastName, email, "", address, city, phone));

        return "redirect:/orders";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/confirmOrderOldUser", method = RequestMethod.POST)
    public  String confirmOrderOldUser (@RequestParam(value = "firstName") String firstName,
                                        @RequestParam(value = "lastName") String lastName,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "address") String address,
                                        @RequestParam(value = "city") String city,
                                        @RequestParam(value = "phone") String phone, Model model){

        model.addAttribute("Error", confirmOrderService.confirm(firstName, lastName, email, "123", address, city, phone));

        return "redirect:/orders";
    }

    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/registerPage", method = RequestMethod.GET)
    public String registerPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        return "registerPage";
    }

    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/confirmRegistered", method = RequestMethod.POST)
    public String registeredNewUser(@RequestParam(value = "firstName") String firstName,
                                    @RequestParam(value = "lastName") String lastName,
                                    @RequestParam(value = "email") String email,
                                    @RequestParam(value = "address") String address,
                                    @RequestParam(value = "city") String city,
                                    @RequestParam(value = "phone") String phone,
                                    @RequestParam(value = "password") String password){
        userService.createNewUser(firstName, lastName, email, password, address, city, phone, "USER" );

        return "redirect:/";
    }

}
