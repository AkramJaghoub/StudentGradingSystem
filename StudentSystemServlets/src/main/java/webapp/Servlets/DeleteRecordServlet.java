package webapp.Servlets;

import Database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteRecord")
public class DeleteRecordServlet extends HttpServlet {
    Database db = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        request.setAttribute("table", table);
        request.setAttribute("headers", db.getTableColumns(table));
        request.setAttribute("rowsData", db.getTableContent(table));
        request.getRequestDispatcher("/WEB-INF/views/delete_record.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        String primaryKeyColumn = db.getTableColumns(table).get(0);
        String idToDelete = request.getParameter("idToDelete");
        if (!db.isIdExists(idToDelete, table)) {
            request.setAttribute("errorMessage", "Error: " + primaryKeyColumn + " ID doesn't exist. Please enter a valid ID!");
        } else {
            boolean isDeleted = db.deleteRecord(table, idToDelete);
            if (isDeleted) {
                request.setAttribute("successMessage", "Successfully deleted the record.");
            } else {
                request.setAttribute("errorMessage", "No record was found with the specified ID.");
            }
        }

        doGet(request, response);
    }
}