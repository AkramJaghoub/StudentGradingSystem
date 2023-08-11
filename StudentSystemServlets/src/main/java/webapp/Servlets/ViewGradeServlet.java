package webapp.Servlets;

import Model.Role;
import Model.StudentGrades;
import Database.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/viewGrades")
public class ViewGradeServlet extends HttpServlet {
    Database database = Database.getInstance(); // Assuming a default constructor or get an instance

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        Role role = Role.valueOf(request.getParameter("role"));
        StudentGrades studentGrades = database.viewGrades(userId);
        request.setAttribute("username", database.getDbUsername(role, userId));
        request.setAttribute("studentGrades", studentGrades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/view_grade.jsp");
        dispatcher.forward(request, response);
    }
}