package com.ua.faculty.controller;

import com.ua.faculty.entity.Role;
import com.ua.faculty.repository.RoleRepository;
import com.ua.faculty.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.Collections;

@Controller
@AllArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @RequestMapping(value = "/admin/create-teacher",
            method = RequestMethod.GET)
    public String showCreateTeacherForm(Model model) {
        return "create_teacher";
    }

    @RequestMapping(value = "/admin/create-teacher",
            method = RequestMethod.POST)
    public String createTeacher(Model model) {
        model.addAttribute("message",
                "Teacher created successfully");
        return "redirect:success";
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

    @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.POST)
    public String changeBlockStatus(@PathParam(value = "id") final Integer id,
                                    Model model) {
        model.addAttribute("message",
                "Teacher created successfully");
        return "redirect:success";
    }

}
