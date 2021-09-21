package com.ua.faculty.controller;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.entity.User;
import com.ua.faculty.exceptions.UserAlreadyExistsException;
import com.ua.faculty.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            registrationService.register(user);
        } catch (UserAlreadyExistsException error) {
            model.addAttribute("userExists", "");
            return "registration";
        }
        return "redirect:profile";
    }

    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getLogin();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        try{
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
