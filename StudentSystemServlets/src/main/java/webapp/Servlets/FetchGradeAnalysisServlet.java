package webapp.Servlets;

import Database.Database;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetchGradeAnalysis")
public class FetchGradeAnalysisServlet extends HttpServlet {
    private final Database db = Database.getInstance();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        List<Float> grades = db.getGradesByCourse(courseId);
        double average = db.getAverage(grades);
        float median = db.getMedian(grades);
        float highest = db.getHighestGrade(grades);
        float lowest = db.getLowestGrade(grades);
        String gradeAnalysisHTML = generateGradeAnalysisHTML(average, median, highest, lowest);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gradeAnalysisHTML);
    }

    private String generateGradeAnalysisHTML(double average, float median, float highest, float lowest) {
        return "<tr><th>Criteria</th><th>Value</th></tr>" +
                "<tr><td>Average</td><td>" + average + "</td></tr>" +
                "<tr><td>Median</td><td>" + median + "</td></tr>" +
                "<tr><td>Highest</td><td>" + highest + "</td></tr>" +
                "<tr><td>Lowest</td><td>" + lowest + "</td></tr>";
    }
}
