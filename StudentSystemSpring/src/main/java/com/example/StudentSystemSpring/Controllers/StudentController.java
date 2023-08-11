package com.example.StudentSystemSpring.Controllers;

import com.example.StudentSystemSpring.Data.DAO;
import com.example.StudentSystemSpring.Model.Role;
import com.example.StudentSystemSpring.Model.StudentGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;;

@Controller
public class StudentController {

    private final DAO dao;

    @Autowired
    public StudentController(DAO dao){
        this.dao = dao;
    }

    @GetMapping("/studentDashboard")
    public String showStudentsDashboard(){
        return "student_dashboard";
    }

    @GetMapping("/viewGrades")
    public String viewGrades(@RequestParam("user_id") String userIdStr,
                             @RequestParam("role") String roleStr,
                             Model model){
        int userId = Integer.parseInt(userIdStr);
        Role role = Role.valueOf(roleStr);
        StudentGrades studentGrades = dao.viewGrades(userId);
        model.addAttribute("username", dao.getDbUsername(role, userId));
        model.addAttribute("studentGrades", studentGrades);
        return "view_grades";
    }
}
