package com.example.StudentSystemSpring.Controllers;

import com.example.StudentSystemSpring.Data.DAO;
import com.example.StudentSystemSpring.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EnrollCourseController {

    private final DAO dao;

    @Autowired
    public EnrollCourseController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/enrollCourse")
    public String courseEnrollmentPage(@RequestParam("user_id") String userIdStr,
                                       @RequestParam("role") String roleStr,
                                       Model model){
        int userId = Integer.parseInt(userIdStr);
        Role role = Role.valueOf(roleStr);
        Map<Integer, String> availableCourses = dao.getAvailableCourses(userId, role);
        model.addAttribute("user_id", userId);
        model.addAttribute("role", role); // Set the Role enum directly
        model.addAttribute("availableCourses", availableCourses);
        return "enroll_course";
    }

    @PostMapping("/enrollCourse")
    public String enrollCourse(@RequestParam("user_id") String userIdStr,
                               @RequestParam("role") String roleStr,
                               @RequestParam("course_id") String courseId,
                               Model model){
        int userId = Integer.parseInt(userIdStr);
        Role role = Role.valueOf(roleStr);
        String tableName = role == Role.STUDENT ? "student_course" : "instructor_course";
        boolean isEnrolled = dao.enrollCourse(userId, role, tableName, courseId);
        Map<Integer, String> availableCourses = dao.getAvailableCourses(userId, role);
        model.addAttribute("availableCourses", availableCourses);
        if(isEnrolled){
            model.addAttribute("message", "Successfully enrolled in the course!");
        }else{
            model.addAttribute("errorMessage", "Failed to enroll/assign the course. Make sure the course exists.");
        }
        return "enroll_course";
    }
}
