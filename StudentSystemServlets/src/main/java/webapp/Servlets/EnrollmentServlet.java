package webapp.Servlets;

import Model.Role;
import Database.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/enrollCourse")
public class EnrollmentServlet extends HttpServlet {
    private final Database database = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String roleParameter = request.getParameter("role");
        Role role = Role.STUDENT;
        if ("INSTRUCTOR".equals(roleParameter)) {
            role = Role.INSTRUCTOR;
        }
        Map<Integer, String> availableCourses = database.getAvailableCourses(userId, role);
        request.setAttribute("user_id", userId);
        request.setAttribute("role", role);
        request.setAttribute("availableCourses", availableCourses);
        request.getRequestDispatcher("/WEB-INF/views/enroll_course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String courseId = request.getParameter("course_id");
        String roleParameter = request.getParameter("role");
        // Determine the role based on the parameter value
        Role role = Role.STUDENT;
        if ("INSTRUCTOR".equals(roleParameter)) {
            role = Role.INSTRUCTOR;
        }
        String tableName = role == Role.STUDENT ? "student_course" : "instructor_course";
        boolean isEnrolled = database.enrollCourse(userId, role, tableName, courseId);
        Map<Integer, String> availableCourses = database.getAvailableCourses(userId, role); // Add this line
        request.setAttribute("availableCourses", availableCourses); // And this line
        if (isEnrolled) {
            request.setAttribute("message", "Successfully enrolled in the course!");
        } else {
            request.setAttribute("errorMessage", "Failed to enroll/assign the course. Make sure the course exists.");
        }
        request.getRequestDispatcher("/WEB-INF/views/enroll_course.jsp").forward(request, response);
    }
}