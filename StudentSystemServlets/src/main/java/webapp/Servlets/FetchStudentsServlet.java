package webapp.Servlets;

import Model.StudentGrades;
import Database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/fetchStudents")
public class FetchStudentsServlet extends HttpServlet {
    Database database = Database.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        Map<Integer, StudentGrades> studentsMap = database.getAllStudentsForCourse(courseId);
        String studentsTableHTML = generateStudentsTableHTML(studentsMap);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(studentsTableHTML);
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
}
