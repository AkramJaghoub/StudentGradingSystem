/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-08-07 03:33:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
 String table = (String) request.getAttribute("table"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Add Record to ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${table}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Your CSS styling here (same as delete.jsp and update.jsp) */\r\n");
      out.write("        /* I am adding only the styles relevant to create.jsp */\r\n");
      out.write("\r\n");
      out.write("        /* The top bar and form container styles */\r\n");
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
      out.write("        .form-container {\r\n");
      out.write("            flex: 1;\r\n");
      out.write("            background-color: #ffffff;\r\n");
      out.write("            padding: 30px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-group {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: row;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            margin: 10px 0;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-group label {\r\n");
      out.write("            width: 40%;\r\n");
      out.write("            text-align: right;\r\n");
      out.write("            padding-right: 10px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-group input {\r\n");
      out.write("            width: 55%;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: cornflowerblue;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            transition: background-color 0.2s ease-in-out;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: green;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @media (max-width: 768px) {\r\n");
      out.write("            .form-container {\r\n");
      out.write("                width: 90%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group {\r\n");
      out.write("                flex-direction: column;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group label,\r\n");
      out.write("            .form-group input {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group label {\r\n");
      out.write("                margin-bottom: 5px;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: row;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .table-container {\r\n");
      out.write("            flex: 1;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            overflow-x: auto;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table {\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        th, td {\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"top-bar\">Student grading system</div>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("        <h3>Add a new record to ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${table}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("        <p style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("        <p style=\"color: green;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${successMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("        <form action=\"/addRecord\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"table\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${table}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("            ");
 if (!"courses".equals(table)) { 
      out.write("\r\n");
      out.write("            <!-- Student or Instructor Form -->\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"userId\">Enter User ID: </label>\r\n");
      out.write("                <input type=\"text\" id=\"userId\" name=\"userId\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"username\">Enter Username: </label>\r\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"password\">Enter Password: </label>\r\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
 } else { 
      out.write("\r\n");
      out.write("            <!-- Course Form -->\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"courseId\">Enter Course ID: </label>\r\n");
      out.write("                <input type=\"text\" id=\"courseId\" name=\"courseId\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"course_name\">Enter Course Name: </label>\r\n");
      out.write("                <input type=\"text\" id=\"course_name\" name=\"course_name\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            <button type=\"submit\">Add Record</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Display the table content -->\r\n");
      out.write("    <div class=\"table-container\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                ");
 List<String> headers = (List<String>) request.getAttribute("headers");
                    if (headers != null) {
                        for (String header : headers) { 
      out.write("\r\n");
      out.write("                <th>");
      out.print( header );
      out.write("</th>\r\n");
      out.write("                ");
     }
                } 
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 List<String[]> rowsData = (List<String[]>) request.getAttribute("rowsData");
                if (rowsData != null) {
                    for (String[] row : rowsData) { 
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                ");
 for (String cell : row) { 
      out.write("\r\n");
      out.write("                <td>");
      out.print( cell );
      out.write("</td>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
     }
            } 
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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
