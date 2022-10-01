package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class CartController {

    public final CartService cartService;

    @GetMapping("/cart")
    public String showCard(Model model) {

        model.addAttribute("cart", CartServiceImpl.CART);
//        model.addAttribute("cartItemList", CartServiceImpl.CART.getCartItemList());
//        model.addAttribute("cartTotalAmount", CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable UUID productId, @PathVariable Integer quantity) {

        cartService.addToCart(productId, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteFromCart(@PathVariable UUID productId) {

        cartService.deleteFromCart(productId);

        return "redirect:/cart";
    }
}
