package webapp.Servlets;

import Model.Role;
import Database.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/gradeAnalysis")
public class GradeAnalysisServlet extends HttpServlet {
    Database db = Database.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("user_id");
        String roleString = request.getParameter("role");
        Role role = Role.valueOf(roleString);
        int userId = Integer.parseInt(userIdStr);
        request.setAttribute("username", db.getDbUsername(role, userId));
        request.setAttribute("courses", db.viewCourses(userId, role));
        request.setAttribute("studentsCount", db.getStudentCountForCourses());
        request.setAttribute("role", role);
        request.setAttribute("user_id", userId);
        request.getRequestDispatcher("/WEB-INF/views/grade_analysis.jsp").forward(request, response);
    }
}