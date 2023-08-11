package webapp.Servlets;

import Model.Role;
import Util.Validation;
import Database.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    Database db = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("user_id");
        String password = request.getParameter("password");
        String roleStr = request.getParameter("role");
        Role role;

        if (roleStr == null || roleStr.isEmpty()) {
            if (db.isAdminCredentials(userIdStr, password)) {
                role = Role.ADMIN;
            } else {
                request.setAttribute("errorMessage", "Please choose one of the roles.");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                return;
            }
        } else {
            role = Role.valueOf(roleStr);
            String errorMessage = Validation.validateUserInput(role, userIdStr, password);
            if (errorMessage != null) {
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                return;
            }
        }

        System.out.println(role);
        if (role == Role.STUDENT || role == Role.INSTRUCTOR) {
            int userId = Integer.parseInt(userIdStr);
            request.setAttribute("user_id", userId);
            request.setAttribute("username", db.getDbUsername(role, userId));
            if (role == Role.STUDENT) {
                request.getRequestDispatcher("/WEB-INF/views/student_dashboard.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/instructor_dashboard.jsp").forward(request, response);
            }
        } else if (role == Role.ADMIN) {
            request.setAttribute("username", userIdStr);
            request.getRequestDispatcher("/WEB-INF/views/admin_dashboard.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
