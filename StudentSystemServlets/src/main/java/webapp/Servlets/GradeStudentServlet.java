package webapp.Servlets;

import Model.Role;
import Database.Database;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/gradeStudent")
public class GradeStudentServlet extends HttpServlet {
    Database database = Database.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int courseId = parseParameter(request);
        Role role = Role.valueOf(request.getParameter("role"));
        request.setAttribute("username", database.getDbUsername(role, userId));
        request.setAttribute("courses", database.viewCourses(userId, role));
        request.setAttribute("students", database.getAllStudentsForCourse(courseId));
        request.setAttribute("studentsCount", database.getStudentCountForCourses());
        request.setAttribute("course_id", courseId);
        forwardTo(request, response, "/WEB-INF/views/grade_student.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        float grade = Float.parseFloat(request.getParameter("grade"));
        String option = request.getParameter("option");
        boolean gradeExists = database.gradeExistsForStudent(studentId, courseId);
        String feedbackMessage = "";
        boolean success = false;
        if ("Add".equals(option)) {
            if (!gradeExists) {
                success = database.addOrUpdateStudentGrade(courseId, studentId, grade, option);
                feedbackMessage = success ? "Grade added successfully!" : "Error adding grade. Please try again.";
            } else {
                feedbackMessage = "Grade already exists for the selected student in the course.";
            }
        } else { //update option
            success = database.addOrUpdateStudentGrade(courseId, studentId, grade, option);
            feedbackMessage = success ? "Grade updated successfully!" : "Error updating grade. Please try again.";
        }
        request.setAttribute("feedbackMessage", feedbackMessage);
        request.setAttribute("success", success);
        request.setAttribute("course_id", courseId);
        request.setAttribute("student_id", studentId);
        doGet(request, response);
    }

    private int parseParameter(HttpServletRequest request) {
        String paramValue = request.getParameter("course_id");
        return (paramValue != null && !paramValue.isEmpty()) ? Integer.parseInt(paramValue) : -1;
    }

    private void forwardTo(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}