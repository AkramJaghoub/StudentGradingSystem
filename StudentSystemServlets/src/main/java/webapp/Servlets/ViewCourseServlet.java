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
import java.util.Map;

@WebServlet(urlPatterns = "/viewCourses")
public class ViewCourseServlet extends HttpServlet {
    Database database = Database.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        Role role = Role.valueOf(request.getParameter("role"));
        request.setAttribute("username", database.getDbUsername(role, userId));
        Map<Integer, String> courses = database.viewCourses(userId, role);
        request.setAttribute("courses", courses);
        // if it is instructor get the student count for each course
        if (role == Role.INSTRUCTOR) {
           Map<Integer, Integer> studentsCount = database.getStudentCountForCourses();
            request.setAttribute("studentsCount", studentsCount);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/view_course.jsp");
        dispatcher.forward(request, response);
    }
}