package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO, new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }


    @Override
    public Cart addToCart(UUID productId, Integer quantity) {

        // todo retrieve product from repository method
        // todo initialise cart item
        // todo calculate cart total amount
        // todo add to cart

        Product productToAdd = productService.findProductById(productId);

        boolean check = CART.getCartItemList().stream().anyMatch(cartItem -> cartItem.getProduct().equals(productToAdd));

        if (check) {

            CartItem cartItem = CART.getCartItemList().stream().filter(item -> item.getProduct().equals(productToAdd)).findFirst().get();

            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItem.setTotalAmount(cartItem.getTotalAmount().add(cartItem.getProduct().getPrice()));

            CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getProduct().getPrice()));

        } else {

            CartItem cartItem = new CartItem();

            cartItem.setProduct(productToAdd);
            cartItem.setQuantity(quantity);
            cartItem.setTotalAmount(productToAdd.getPrice().multiply(BigDecimal.valueOf(quantity)));

            CART.getCartItemList().add(cartItem);
            CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        }

//        productToAdd.setRemainingQuantity(productToAdd.getRemainingQuantity() - 1);

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId) {
        //todo delete product object from cart using stream

        CartItem itemToDelete = CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().toString().equals(productId.toString()))
                .findFirst().orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(itemToDelete.getTotalAmount()));


//        itemToDelete.getProduct().setRemainingQuantity(itemToDelete.getProduct().getRemainingQuantity() + itemToDelete.getQuantity());

        return CART.getCartItemList().remove(itemToDelete);

    }
}
