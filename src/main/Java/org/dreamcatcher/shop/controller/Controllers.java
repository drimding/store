package org.dreamcatcher.shop.controller;

import org.dreamcatcher.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("ProductCategoru", productCategoryService.getAllProductCategory());
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());

        return "home";
    }

    @RequestMapping (value = "/getItemsContent", method = RequestMethod.GET)
    public String getItemsContent(@RequestParam String id, Model model){
        model.addAttribute("ProductCategoru", productCategoryService.getAllProductCategory());
        model.addAttribute("Products", productsService.getProductsByProductCategoryId(id));
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        return "home";
    }

    @RequestMapping(value = "/add-basketElement", method = RequestMethod.POST)
    public String addElementInbasket(@RequestParam (value = "productId") String  productId,
                                     @RequestHeader(value = "Referer") String  Referer, Model model) throws MalformedURLException {

        URL aURL = new URL(Referer);
        String url = aURL.getQuery();
        String[] id = url.split("=");

        basketService.setBasketItem(productId);
        return "redirect:/getItemsContent?id="+id[1];
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCheckoutPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        model.addAttribute("busketItems", basketService.getItemsBySessionId());
        return "checkout";
    }

    @RequestMapping (value = "/delItem-inBasket", method = RequestMethod.POST)
    public  String delItemInBasket(@RequestParam (value = "basketItemId") String busketItemId){
        basketService.deleteBasketItem(busketItemId);
        return "redirect:/checkout";
    }

    @RequestMapping (value = "/updateQuantity-inBasket", method = RequestMethod.POST)
    public String updateQuantityInBasket(@RequestParam (value = "basketItemId") String basketItemId,
                                         @RequestParam(value = "quantity") String quantity){

        basketService.updateQuantityInBasket(basketItemId, quantity);
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        return "confirm";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public  String showOrderPage(Model model){
        model.addAttribute("countItem", basketService.getCountItemsBySessinId());
        return "orders";
    }

    @RequestMapping(value = "/confirmOrderNewUser", method = RequestMethod.POST)
    public  String confirmOrder(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "address") String address,
                                @RequestParam(value = "city") String city,
                                @RequestParam(value = "phone") String phone, Model model){

        model.addAttribute("Error", confirmOrderService.confirm(firstName, lastName, email, "", address, city, phone));

        return "redirect:/orders";
    }


}
