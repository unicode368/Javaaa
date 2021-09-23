package com.ua.faculty.controller;

import com.ua.faculty.dto.CourseDTO;
import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.entity.Role;
import com.ua.faculty.repository.RoleRepository;
import com.ua.faculty.repository.UserRepository;
import com.ua.faculty.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;

@Controller
@AllArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AdminService adminService;

    @RequestMapping(value = "/admin/create-teacher",
            method = RequestMethod.GET)
    public String showCreateTeacherForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "create_teacher";
    }

    @RequestMapping(value = "/admin/create-course",
            method = RequestMethod.GET)
    public String showCreateCourseForm(Model model) {
        model.addAttribute("courseDTO", new CourseDTO());
        model.addAttribute("teachers",
                userRepository.findAllByRoles(
                        roleRepository.findByName("teacher")
                                .orElseThrow(() -> new UsernameNotFoundException(""))
                ).get());
        return "create-course";
    }

    @RequestMapping(value = "/admin/create-teacher", method = RequestMethod.POST)
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

    @PostMapping(value = "/admin/user/{id}")
    public String changeBlockStatus(@PathVariable final String id) {
        adminService.changeUserBlockStatus(Long.parseLong(id));
        return "redirect:/admin/users";
    }

}
