package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login/{email}/{phoneNumber}")
    public String login(@PathVariable String email, @PathVariable String phoneNumber, Model model){
//
//        Login login = new Login();
//        login.setEmail(email);
//        login.setPhoneNumber(phoneNumber);
//
//        model.addAttribute("email", login.getEmail());
//        model.addAttribute("phoneNumber", login.getPhoneNumber());
//        model.addAttribute("loginMessage", "login successful");

        model.addAttribute("email", email);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("loginMessage", "login successful");

        return "login/login-info";

    }

}
