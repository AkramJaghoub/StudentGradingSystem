/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-08-06 13:29:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Instructor Dashboard</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        * {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            font-family: 'Arial', sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: #f4f4f4;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .top-bar {\r\n");
      out.write("            background-color: #2d2d2d;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            padding: 20px 0;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            border-bottom: 5px solid #f0db4f;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            margin-bottom: 40px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h3 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            margin-top: 40px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        p {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #555;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table {\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("            background-color: #ffffff;\r\n");
      out.write("            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        th, td {\r\n");
      out.write("            border: 1px solid #dddddd;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #f2f2f2;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        tr:nth-child(even) {\r\n");
      out.write("            background-color: #f2f2f2;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        tr:hover {\r\n");
      out.write("            background-color: #ddd;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: cornflowerblue;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 8px 16px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            transition: background-color 0.2s ease-in-out;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: green;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        td.description {\r\n");
      out.write("            text-align: left;\r\n");
      out.write("            padding-left: 20px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            flex: 2;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"top-bar\">Student grading system</div>\r\n");
      out.write("<h3>Admin Dashboard</h3>\r\n");
      out.write("<div style=\"text-align: center; margin-top: 20px;\">\r\n");
      out.write("    <p>Welcome to your dashboard <strong>Admin</strong> :)</p>\r\n");
      out.write("</div>\r\n");
      out.write("<table>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>Table</th>\r\n");
      out.write("        <th>Description</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>\r\n");
      out.write("            <form action=\"/crud\" method=\"GET\">\r\n");
      out.write("                <input type=\"hidden\" name =\"role\" value=\"ADMIN\">\r\n");
      out.write("                <input type=\"hidden\" name =\"table\" value=\"students\">\r\n");
      out.write("                <button type=\"submit\">Students</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td class=\"description\">it allows you to do crud operations on students table</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>\r\n");
      out.write("            <form action=\"/crud\" method=\"GET\">\r\n");
      out.write("                <input type=\"hidden\" name =\"role\" value=\"ADMIN\">\r\n");
      out.write("            <input type=\"hidden\" name =\"table\" value=\"instructors\">\r\n");
      out.write("            <button type=\"submit\">Instructors</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td class=\"description\">it allows you to do crud operations on instructors table</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>\r\n");
      out.write("            <form action=\"/crud\" method=\"GET\">\r\n");
      out.write("                <input type=\"hidden\" name =\"role\" value=\"ADMIN\">\r\n");
      out.write("                <input type=\"hidden\" name =\"table\" value=\"courses\">\r\n");
      out.write("                <button type=\"submit\">Courses</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td class=\"description\">it allows you to do crud operations on courses table</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
