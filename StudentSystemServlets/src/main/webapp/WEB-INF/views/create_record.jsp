<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String table = (String) request.getAttribute("table"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Record to ${table}</title>
    <style>
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

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            max-width: 1200px;
            width: 100%;
            margin: 20px;
        }

        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            width: 30%;
            max-width: 400px;
            margin-right: 20px;
            height: fit-content;
        }

        input{
            width: 95%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #e1e1e1;
            border-radius: 5px;
            font-size: 16px;
            transition: border 0.3s ease;
        }

        button {
            width: 100%;
            background-color: cornflowerblue;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.2s ease-in-out;
            margin-top: 20px;
        }

        button:hover {
            background-color: green;
        }

        @media (max-width: 768px) {
            .form-container {
                width: 90%;
            }
        }

        .table-container {
            width: 70%;
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
<div class="container">
    <div class="form-container">
        <h3>Add a new record to ${table}</h3>
        <p style="color: red;">${errorMessage}</p>
        <p style="color: green;">${successMessage}</p>
        <form action="/addRecord" method="post">
            <input type="hidden" name="table" value="${table}">
            <% if (!"courses".equals(table)) { %>
            <!-- Student or Instructor Form -->
            <div class="form-group">
                <label for="userId">Enter User ID: </label>
                <input type="text" id="userId" name="userId" required>
            </div>
            <div class="form-group">
                <label for="username">Enter Username: </label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Enter Password: </label>
                <input type="password" id="password" name="password" required>
            </div>
            <% } else { %>
            <!-- Course Form -->
            <div class="form-group">
                <label for="courseId">Enter Course ID: </label>
                <input type="text" id="courseId" name="courseId" required>
            </div>
            <div class="form-group">
                <label for="course_name">Enter Course Name: </label>
                <input type="text" id="course_name" name="course_name" required>
            </div>
            <% } %>
            <button type="submit">Add Record</button>
        </form>
    </div>


    <div class="table-container">
        <table>
            <tr>
                <% List<String> headers = (List<String>) request.getAttribute("headers");
                    if (headers != null) {
                        for (String header : headers) { %>
                <th><%= header %></th>
                <%     }
                } %>
            </tr>
            <% List<String[]> rowsData = (List<String[]>) request.getAttribute("rowsData");
                if (rowsData != null) {
                    for (String[] row : rowsData) { %>
            <tr>
                <% for (String cell : row) { %>
                <td><%= cell %></td>
                <% } %>
            </tr>
            <%     }
            } %>
        </table>
    </div>
</div>
</body>
</html>