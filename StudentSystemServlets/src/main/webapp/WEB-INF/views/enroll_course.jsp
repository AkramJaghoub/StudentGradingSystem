<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Courses</title>
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
            margin-bottom: 20px;
        }

        h3 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        p {
            text-align: center;
            color: #555;
            margin-top: 5px;
        }

        table {
            width: 70%;
            margin: 20px auto;
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

        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .input-box {
            margin-top: 10px;
            text-align: center;
        }

        .input-box label {
            font-size: 16px;
            margin-bottom: 5px;
            display: block;
            text-align: left;
            color: #555;
            width: 100%;
        }

        .input-box input[type="text"] {
            width: 100%;
            padding: 15px;
            margin-bottom: 15px;
            border: 1px solid #e1e1e1;
            border-radius: 5px;
            font-size: 16px;
            transition: border 0.3s ease;
        }

        .input-box button {
            background-color: cornflowerblue;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
            transition: background-color 0.2s ease-in-out;
        }

        .input-box button:hover {
            background-color: green;
        }

        .table-header {
            width: 70%;
            margin: 10px auto 5px;
            background-color: #ffffff;
            padding: 10px;
            border: 1px solid #ddd;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="top-bar">Student grading system</div>
<div class="table-header">Available Courses that you can assign ${studentName}</div>
<table>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
    </tr>
    <c:forEach items="${availableCourses}" var="course">
        <tr>
            <td>${course.key}</td>
            <td>${course.value}</td>
        </tr>
    </c:forEach>
</table>

<div id="message-box" style="margin-top: 10px; text-align: center;">
    <c:choose>
        <c:when test="${not empty message}">
            <p style="color: green;">${message}</p>
        </c:when>
        <c:when test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:when>
    </c:choose>
</div>

<div class="input-box">
    <p>Enter Course ID:</p>
    <form action="/enrollCourse" method="POST" class="form-container">
        <input type="hidden" name="user_id" value="${user_id}" />
        <input type="hidden" name="role" value="${role}" />
        <input id="course_id" type="text" name="course_id" placeholder="Enter Course ID" />
        <button type="submit">Enroll/Assign Course</button>
    </form>
</div>
</body>
</html>