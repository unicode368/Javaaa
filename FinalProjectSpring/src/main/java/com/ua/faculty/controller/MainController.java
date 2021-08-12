package com.ua.faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index() {
       return "index";
   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {
       return "login";
   }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

}
