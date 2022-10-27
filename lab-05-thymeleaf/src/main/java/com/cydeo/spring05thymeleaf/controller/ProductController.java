package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.repository.impl.ProductRepositoryImpl;
import com.cydeo.spring05thymeleaf.service.ProductService;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    public final ProductRepository productRepository;
    public final ProductService productService;

    @GetMapping("/create-form")
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());

        return "product/create-product";

    }

    @PostMapping("/create-product")
    public String addProduct(@ModelAttribute("product") Product product) {

        productService.productCreate(product);

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {

        model.addAttribute("productList", productService.listProduct());

        return "product/list";

    }
}
