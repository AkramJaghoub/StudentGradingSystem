<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instructor Dashboard</title>
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

        button {
            background-color: cornflowerblue;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
            transition: background-color 0.2s ease-in-out;
        }

        button:hover {
            background-color: green;
        }

        td.description {
            text-align: left;
            padding-left: 20px;
            font-size: 14px;
            color: #333;
            flex: 2;
        }

    </style>
</head>
<body>
<div class="top-bar">Student grading system</div>
<h3>Instructor Dashboard</h3>
<div style="text-align: center; margin-top: 20px;">
    <p>Welcome to your dashboard <strong>${username}</strong> :)</p>
</div>
<table>
    <tr>
        <th>Option</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>
            <form action="/viewCourses" method="GET">
                <input type="hidden" name="user_id" value="${user_id}">
                <input type="hidden" name ="role" value="INSTRUCTOR">
                <button type="submit">View Courses</button>
            </form>
        </td>
        <td class="description">view all the courses you are instructing</td>
    </tr>
    <tr>
        <td>
            <form action="/gradeStudent" method="GET">
                <input type="hidden" name="user_id" value="${user_id}">
                <input type="hidden" name ="role" value="INSTRUCTOR">
                <button type="submit">Grade Student</button>
            </form>
        </td>
        <td class="description">add/update a grade for a student in a course</td>
    </tr>
    <tr>
        <td>
            <form action="/gradeAnalysis" method="GET">
                <input type="hidden" name="user_id" value="${user_id}">
                <input type="hidden" name="role" value="INSTRUCTOR">
                <button type="submit">Grades Analysis</button>
            </form>
        </td>
        <td class="description">display of statistical data (e.g., class average, median, highest, and lowest marks)</td>
    </tr>
    <tr>
        <td>
            <form action="/enrollCourse" method="GET">
                <input type="hidden" name="user_id" value="${user_id}">
                <input type="hidden" name="role" value="INSTRUCTOR">
                <button type="submit">Course Enrollment</button>
            </form>
        </td>
        <td class="description">you can assign yourself a course</td>
    </tr>
</table>
</body>
</html>