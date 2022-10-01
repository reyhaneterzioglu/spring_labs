package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;

@Controller
public class ProfileController {


    @RequestMapping("/profile")
    public String showProfile(Model model){

        Profile profile = new Profile();
        profile.setName("reyhan");
        profile.setSurname("terzioglu");
        profile.setUserName("reyhanterzioglu");
        profile.setPhoneNumber("55110384");
        profile.setEmail("rey@gmail.com");
        profile.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile", profile);

        return "profile/profile-info";

    }
}
