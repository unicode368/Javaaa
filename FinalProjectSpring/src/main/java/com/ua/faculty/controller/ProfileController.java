package com.ua.faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;*/
        return "profile";
    }
}
