package com.ua.faculty.controller;

import com.ua.faculty.entity.Role;
import com.ua.faculty.repository.RoleRepository;
import com.ua.faculty.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@AllArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @RequestMapping("/admin/create-teacher")
    public String createTeacher(Model model) {
        return "create_teacher";
    }

    @RequestMapping("/admin/users")
    public String showStudents(Model model) {
        model.addAttribute("users",
                userRepository.findAllByRoles(
                        roleRepository.findByName("user")
                                .orElseThrow(() -> new UsernameNotFoundException(""))
                ).get());
        return "students";
    }


}
