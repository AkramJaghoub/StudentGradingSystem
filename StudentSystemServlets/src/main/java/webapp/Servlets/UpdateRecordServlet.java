package webapp.Servlets;

import Database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/updateRecord")
public class UpdateRecordServlet extends HttpServlet {
    Database db = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        request.setAttribute("table", table);
        List<String> columns = db.getTableColumns(table);
        request.setAttribute("columns", columns);
        List<String> headers = db.getTableColumns(table);
        List<String[]> rowsData = db.getTableContent(table);
        request.setAttribute("headers", headers);
        request.setAttribute("rowsData", rowsData);
        request.setAttribute("column1", columns.get(0));
        request.setAttribute("column2", columns.get(1));
        request.getRequestDispatcher("/WEB-INF/views/update_record.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        List<String> columns = db.getTableColumns(table);
        int columnChoice = Integer.parseInt(request.getParameter("columnChoice")) - 1;
        String columnToUpdate = columns.get(columnChoice);
        String primaryKeyColumn = columns.get(0);
        String idToUpdate = request.getParameter("idToUpdate");
        String newValue = request.getParameter("newValue");
        if (!db.isIdExists(idToUpdate, table)) {
            request.setAttribute("errorMessage", "Error: " + primaryKeyColumn + " ID doesn't exist. Please enter one of the displayed ids!");
            doGet(request, response);
            return;
        }
        if (db.isIdExists(newValue, table)) {
            request.setAttribute("errorMessage", "Error: " + primaryKeyColumn + " ID already exists. Please enter a different ID.");
            doGet(request, response);
            return;
        }
        boolean isUpdated = db.updateRecord(table, columnToUpdate, primaryKeyColumn, idToUpdate, newValue);
        if (isUpdated) {
            request.setAttribute("successMessage", "Successfully updated the record.");
        } else {
            request.setAttribute("errorMessage", "No record was found with the specified ID.");
        }
        doGet(request, response);
    }
}