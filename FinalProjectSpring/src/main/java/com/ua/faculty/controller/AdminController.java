package com.ua.faculty.controller;

import com.ua.faculty.dto.CourseDTO;
import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.entity.Role;
import com.ua.faculty.repository.CourseRepository;
import com.ua.faculty.repository.RoleRepository;
import com.ua.faculty.repository.UserRepository;
import com.ua.faculty.service.AdminService;
import com.ua.faculty.service.CourseService;
import com.ua.faculty.service.UserService;
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

    private final UserService userService;
    private final CourseService courseService;
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
                userService.getUsersByRoleName("teacher"));
        return "create-course";
    }

    @RequestMapping(value = "/admin/courses/{id}/edit",
            method = RequestMethod.GET)
    public String showEditCourseForm(Model model, @PathVariable final String id,
                                     @ModelAttribute("courseDTO") CourseDTO course) {
        model.addAttribute("courseDTO", new CourseDTO());
        model.addAttribute("courses", courseService
                    .getCourseById(Long.parseLong(id)));
        model.addAttribute("teachers",
                userService.getUsersByRoleName("teacher"));
        return "edit-course";
    }

    @RequestMapping("/admin/users")
    public String showStudents(Model model) {
        model.addAttribute("users",
                userService.getUsersByRoleName("user"));
        return "students";
    }

    @PostMapping(value = "/admin/user/{id}")
    public String changeBlockStatus(@PathVariable final String id) {
        adminService.changeUserBlockStatus(Long.parseLong(id));
        return "redirect:/admin/users";
    }

}
