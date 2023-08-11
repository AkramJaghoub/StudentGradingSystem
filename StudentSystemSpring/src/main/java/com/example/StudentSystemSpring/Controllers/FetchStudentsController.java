package com.example.StudentSystemSpring.Controllers;

import com.example.StudentSystemSpring.Data.DAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentSystemSpring.Model.StudentGrades;
import java.util.List;
import java.util.Map;

@RestController
public class FetchStudentsController {
    private final DAO dao;

    public FetchStudentsController(DAO dao){
        this.dao = dao;
    }

    @GetMapping("/fetchStudents")
    public String fetchStudents(@RequestParam("course_id") int courseId) {
        Map<Integer, StudentGrades> studentsMap = dao.getAllStudentsForCourse(courseId);
        return generateStudentsTableHTML(studentsMap);
    }

    private String generateStudentsTableHTML(Map<Integer, StudentGrades> studentsMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<th>Student ID</th>");
        sb.append("<th>Student Name</th>");
        sb.append("<th>Grade</th>");
        sb.append("</tr>");
        for (StudentGrades studentGrades : studentsMap.values()) {
            int studentId = studentGrades.getStudentId();
            String studentName = studentGrades.getStudentName();
            String grade = "No Grade";
            if (!studentGrades.getCourseGrades().isEmpty()) {
                if (!Double.isNaN(studentGrades.getCourseGrades().get(0).getGrade())) {
                    grade = Double.toString(studentGrades.getCourseGrades().get(0).getGrade());
                }
            }
            sb.append("<tr>");
            sb.append("<td>").append(studentId).append("</td>");
            sb.append("<td>").append(studentName).append("</td>");
            sb.append("<td>").append(grade).append("</td>");
            sb.append("</tr>");
        }
        return sb.toString();
    }

    @GetMapping("/fetchGradeAnalysis")
    public String fetchGradeAnalysis(@RequestParam("course_id") int courseId) {
        List<Float> grades = dao.getGradesByCourse(courseId);
        double average = dao.getAverage(grades);
        float median = dao.getMedian(grades);
        float highest = dao.getHighestGrade(grades);
        float lowest = dao.getLowestGrade(grades);
        return "<tr><th>Criteria</th><th>Value</th></tr>" +
                "<tr><td>Average</td><td>" + average + "</td></tr>" +
                "<tr><td>Median</td><td>" + median + "</td></tr>" +
                "<tr><td>Highest</td><td>" + highest + "</td></tr>" +
                "<tr><td>Lowest</td><td>" + lowest + "</td></tr>";
    }
}