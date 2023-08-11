<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.CourseGrade" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Common CSS style (you can add additional styling here if needed) -->
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .top-bar {
            background-color: #2d2d2d;
            color: white;
            text-align: center;
            padding: 10px 0;
            font-weight: bold;
            border-bottom: 5px solid #f0db4f;
            width: 100%;
        }

        .message {
            background-color: #2d2d2d;
            color: white;
            padding: 1rem;
            border-radius: 10px;
            margin-bottom: 1rem;
            font-weight: bold;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 1rem 0;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f5f5f5;
        }

        tr:hover {
            background-color: #f0db4f;
            transition: background-color 0.3s ease;
        }
    </style>
    <title>View Data</title>
</head>
<body>
<div class="top-bar">Student grading system</div>
<%
    String viewType = (String) request.getAttribute("type");
    String username = (String) request.getAttribute("username");
    if ("Grades".equals(viewType)) {
        List<CourseGrade> studentGrades = (List<CourseGrade>) request.getAttribute("dataRows");
%>
<div class="message">Hey <span style="color: #f0db4f;"><%= username %></span>, you didn't tell me that you were that smart 😉</div>
<table>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Grade</th>
    </tr>
    <% for (CourseGrade grade : studentGrades) { %>
    <tr>
        <td><%= grade.getCourseId() %></td>
        <td><%= grade.getCourseName() %></td>
        <td><%= grade.getGrade() %></td>
    </tr>
    <% } %>
</table>
<% } else {
    Map<Integer, String> courseList = (Map<Integer, String>) request.getAttribute("dataRows");
%>
<div class="message">There you go <span style="color: #f0db4f;"><%= username %></span>, your courses 👍</div>
<table>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
    </tr>
    <% for (Map.Entry<Integer, String> entry : courseList.entrySet()) { %>
    <tr>
        <td><%= entry.getKey() %></td>
        <td><%= entry.getValue() %></td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>
