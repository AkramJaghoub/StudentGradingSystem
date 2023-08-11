package webapp.Servlets;

import Database.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/readRecords")
public class ReadRecordServlet extends HttpServlet {
    Database db = Database.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        request.setAttribute("table", table);
        List<String> headers = db.getTableColumns(table);
        List<String[]> rowsData = db.getTableContent(table);
        request.setAttribute("headers", headers);
        request.setAttribute("rowsData", rowsData);
        request.getRequestDispatcher("/WEB-INF/views/read_record.jsp").forward(request, response);
    }
}