package com.ua.faculty.controller;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.exceptions.UserAlreadyExistsException;
import com.ua.faculty.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @PostMapping(value = "/registration")
    public String register(@ModelAttribute("userDTO") @Valid UserDTO user,
                           BindingResult bindingResult, Model model,
                           @RequestParam String role) {
        if (bindingResult.hasErrors()) {
            if (role.equals("user")) {
                return "registration";
            } else {
                return "create_teacher";
            }
        }
        try {
            registrationService.register(user, role);
        } catch (UserAlreadyExistsException error) {
            model.addAttribute("userExists", "");
            return "registration";
        }
        return "redirect:profile";
    }


}
