<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Record</title>

    <style>
        /* Your CSS styling here */
        /* I am adding only the styles relevant to delete_record.jsp */

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
            justify-content: center; /* Align items horizontally to the center */
            align-items: center; /* Align items vertically to the center */
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
            height: fit-content; /* Set the form height to fit its content */
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #e1e1e1;
            border-radius: 5px;
            font-size: 16px;
            transition: border 0.3s ease;
        }

        button[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
        }

        .table-container {
            width: 70%;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
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
        <form action="/deleteRecord" method="post">
            <input type="hidden" name="table" value="${table}">
            <label for="idToDelete">ID of the record to delete:</label>
            <input type="text" name="idToDelete" id="idToDelete" required>

            <% String errorMessage = (String) request.getAttribute("errorMessage");
                String successMessage = (String) request.getAttribute("successMessage");
                if (errorMessage != null) { %>
            <div class="error-message"><%= errorMessage %></div>
            <% } else if (successMessage != null) { %>
            <div class="success-message"><%= successMessage %></div>
            <% } %>

            <button type="submit">Delete Record</button>
        </form>
    </div>

    <!-- Display the table content -->
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
