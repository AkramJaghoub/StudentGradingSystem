package com.example.StudentSystemSpring.Controllers;

import com.example.StudentSystemSpring.Data.DAO;
import com.example.StudentSystemSpring.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InstructorController {
    private final DAO dao;

    @Autowired
    public InstructorController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/instructorDashboard")
    public String showInstructorDashboard() {
        return "instructor_dashboard";
    }

    @GetMapping("/gradeStudent")
    public String showGradeStudentPage(
            @RequestParam("user_id") String userIdStr,
            @RequestParam(value = "course_id", defaultValue = "-1") int courseId,
            @RequestParam("role") String roleString,
            Model model) {
        Role role = Role.valueOf(roleString);
        int userId = Integer.parseInt(userIdStr);
        model.addAttribute("username", dao.getDbUsername(role, userId));
        model.addAttribute("courses", dao.viewCourses(userId, role));
        model.addAttribute("students", dao.getAllStudentsForCourse(courseId));
        model.addAttribute("studentsCount", dao.getStudentCountForCourses());
        model.addAttribute("role", role);
        model.addAttribute("user_id", userId);
        model.addAttribute("course_id", courseId);
        return "grade_student";
    }

    @PostMapping("/gradeStudent")
    public String gradeStudent(
            @RequestParam("user_id") String userIdStr,
            @RequestParam("course_id") int courseId,
            @RequestParam("role") String roleStr,
            @RequestParam("student_id") int studentId,
            @RequestParam("grade") float grade,
            @RequestParam("option") String option,
            RedirectAttributes redirectAttributes) {
        int userId = Integer.parseInt(userIdStr);
        boolean gradeExists = dao.gradeExistsForStudent(studentId, courseId);
        String feedbackMessage = "";
        boolean success = false;
        if ("Add".equals(option)) {
            if (!gradeExists) {
                success = dao.addOrUpdateStudentGrade(courseId, studentId, grade, option);
                feedbackMessage = success ? "Grade added successfully!" : "Error adding grade. Please try again.";
            } else {
                feedbackMessage = "Grade already exists for the selected student in the course.";
            }
        } else {
            success = dao.addOrUpdateStudentGrade(courseId, studentId, grade, option);
            feedbackMessage = success ? "Grade updated successfully!" : "Error updating grade. Please try again.";
        }
        redirectAttributes.addFlashAttribute("feedbackMessage", feedbackMessage);
        redirectAttributes.addFlashAttribute("success", success);
        redirectAttributes.addAttribute("user_id", userId);
        redirectAttributes.addAttribute("course_id", courseId);
        redirectAttributes.addAttribute("role", roleStr);
        return "redirect:/gradeStudent";
    }

    @GetMapping("/gradeAnalysis")
    public String showGradeAnalysisPage(
            @RequestParam("user_id") String userIdStr,
            @RequestParam("role") String roleString,
            Model model) {
        Role role = Role.valueOf(roleString);
        int userId = Integer.parseInt(userIdStr);
        model.addAttribute("username", dao.getDbUsername(role, userId));
        model.addAttribute("courses", dao.viewCourses(userId, role));
        model.addAttribute("studentsCount", dao.getStudentCountForCourses());
        model.addAttribute("role", role);
        model.addAttribute("user_id", userId);
        return "grades_analysis";
    }
}
