<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Courses</title>
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
            padding: 20px 0;
            font-weight: bold;
            border-bottom: 5px solid #f0db4f;
            width: 100%;
            margin-bottom: 40px;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h3 {
            text-align: center;
            color: #333;
            margin-top: 40px;
        }

        p {
            text-align: center;
            color: #555;
            margin-top: 10px;
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
            width: 70%;
            margin: 30px auto;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

    </style>
</head>
<body>
<div class="top-bar">Student grading system</div>
<div class="message">
    Hey <span style="color: #f0db4f;">${username}</span>, courses you're taken 👍
</div>
<table>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <c:if test="${not empty studentsCount}">
            <th>Students Count</th>
        </c:if>
    </tr>
    <c:forEach items="${courses}" var="entry">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
            <c:if test="${not empty studentsCount}">
                <td>${studentsCount[entry.key]}</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>