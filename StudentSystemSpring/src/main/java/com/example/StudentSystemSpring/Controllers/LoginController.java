package com.example.StudentSystemSpring.Controllers;

import com.example.StudentSystemSpring.Data.DAO;
import com.example.StudentSystemSpring.Model.Role;
import com.example.StudentSystemSpring.Util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final DAO dao;

    @Autowired
    public LoginController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_id") String userIdStr,
                        @RequestParam("password") String password,
                        @RequestParam(value = "role", required = false) String roleStr, // Note the required = false
                        Model model) {
        Role role;
        if (roleStr == null || roleStr.isEmpty()) {
            if (dao.isAdminCredentials(userIdStr, password)) {
                role = Role.ADMIN;
            } else {
                model.addAttribute("errorMessage", "Please choose one of the roles.");
                return "login";
            }
        } else {
            role = Role.valueOf(roleStr);
            String errorMessage = Validation.validateUserInput(role, userIdStr, password);
            if (errorMessage != null) {
                model.addAttribute("errorMessage", errorMessage);
                return "login";
            }
        }
        if (role == Role.STUDENT || role == Role.INSTRUCTOR) {
            int userId = Integer.parseInt(userIdStr);
            model.addAttribute("user_id", userId);
            model.addAttribute("username", dao.getDbUsername(role, userId));
            return role == Role.STUDENT ? "student_dashboard" : "instructor_dashboard";
        } else if (role == Role.ADMIN) {
            model.addAttribute("username", userIdStr);
            return "admin_dashboard";
        }
        return "login";
    }
}