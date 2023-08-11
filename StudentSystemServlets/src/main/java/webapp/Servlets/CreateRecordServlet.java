package webapp.Servlets;

import Database.Database;
import Util.PasswordHashing;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/addRecord")
public class CreateRecordServlet extends HttpServlet {
    Database db = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        if (table == null) {
            return;
        }
        request.setAttribute("errorMessage", "");
        request.setAttribute("table", table);
        List<String> headers = db.getTableColumns(table);
        List<String[]> rowsData = db.getTableContent(table);
        request.setAttribute("headers", headers);
        request.setAttribute("rowsData", rowsData);
        request.getRequestDispatcher("/WEB-INF/views/create_record.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        List<String> columns = db.getTableColumns(table);
        Map<String, String> inputData = new HashMap<>();
        request.setAttribute("table", table);

        if (!"courses".equals(table)) {
            String userId = request.getParameter("userId");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (!userId.matches("\\d{7}")) {
                request.setAttribute("errorMessage", "Invalid ID format. ID must be a 7-digit numeric value.");
                request.getRequestDispatcher("/WEB-INF/views/create_record.jsp").forward(request, response);
                return;
            }

            if (db.isIdExists(userId, table)) {
                request.setAttribute("errorMessage", "Error: " + columns.get(0) + " already exists. Please enter a different ID.");
                request.getRequestDispatcher("/WEB-INF/views/create_record.jsp").forward(request, response);
                return;
            }

            inputData.put(columns.get(0), userId);
            inputData.put("username", username);
            String hashedPassword = PasswordHashing.hashPassword(password);
            inputData.put("password", hashedPassword);
        } else {
            String courseId = request.getParameter("courseId");
            String courseName = request.getParameter("course_name");
            if (!courseId.matches("\\d{7}")) {
                request.setAttribute("errorMessage", "Invalid ID format. ID must be a 7-digit numeric value.");
                request.getRequestDispatcher("/WEB-INF/views/create_record.jsp").forward(request, response);
                return;
            }
            if (db.isIdExists(courseId, table)) {
                request.setAttribute("errorMessage", "Error: Course ID already exists. Please enter a different ID.");
                request.getRequestDispatcher("/WEB-INF/views/create_record.jsp").forward(request, response);
                return;
            }
            inputData.put(columns.get(0), courseId);
            inputData.put("course_name", courseName);
        }

        boolean isAdded = db.addRecord(table, inputData);

        if (isAdded) {
            request.setAttribute("successMessage", "Record added successfully");
        } else {
            request.setAttribute("errorMessage", "Record wasn't added; an error occurred");
        }
        doGet(request, response);
    }
}