/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-08-10 23:33:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class enroll_005fcourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Available Courses</title>\r\n");
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
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h3 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        p {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #555;\r\n");
      out.write("            margin-top: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table {\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            margin: 20px auto;\r\n");
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
      out.write("        .form-container {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-box {\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-box label {\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            display: block;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("            color: #555;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-box input[type=\"text\"] {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            margin-bottom: 15px;\r\n");
      out.write("            border: 1px solid #e1e1e1;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            transition: border 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-box button {\r\n");
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
      out.write("        .input-box button:hover {\r\n");
      out.write("            background-color: green;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .table-header {\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            margin: 10px auto 5px;\r\n");
      out.write("            background-color: #ffffff;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"top-bar\">Student grading system</div>\r\n");
      out.write("<div class=\"table-header\">Available Courses that you can assign ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${studentName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("<table>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>Course ID</th>\r\n");
      out.write("        <th>Course Name</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"message-box\" style=\"margin-top: 10px; text-align: center;\">\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"input-box\">\r\n");
      out.write("    <p>Enter Course ID:</p>\r\n");
      out.write("    <form action=\"/enrollCourse\" method=\"POST\" class=\"form-container\">\r\n");
      out.write("        <input type=\"hidden\" name=\"user_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("        <input type=\"hidden\" name=\"role\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${role}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("        <input id=\"course_id\" type=\"text\" name=\"course_id\" placeholder=\"Enter Course ID\" />\r\n");
      out.write("        <button type=\"submit\">Enroll/Assign Course</button>\r\n");
      out.write("    </form>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/enroll_course.jsp(140,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/enroll_course.jsp(140,4) '${availableCourses}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${availableCourses}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/enroll_course.jsp(140,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("course");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        <tr>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.key}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.value}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("        </tr>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/views/enroll_course.jsp(150,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty message}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <p style=\"color: green;\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</p>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/views/enroll_course.jsp(153,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty errorMessage}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <p style=\"color: red;\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</p>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }
}
