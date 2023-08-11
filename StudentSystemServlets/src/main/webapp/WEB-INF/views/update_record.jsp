<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Record</title>

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
            flex-wrap: wrap;
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
            max-width: 100%;
            height: fit-content;
            margin-right: 20px;
            flex: 1;
        }


        .column-selection {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }

        .column-option {
            display: flex;
            align-items: center;
            margin: 10px;
            position: relative;
        }

        .column-option input[type="radio"] {
            position: absolute;
            opacity: 0;
            width: 0;
            height: 0;
        }

        .column-option label {
            padding: 10px 20px;
            cursor: pointer;
            background-color: #eee;
            border: 2px solid #ddd;
            border-radius: 20px;
            transition: background 0.3s;
        }

        .column-option input[type="radio"]:checked + label {
            background-color: #007BFF;
            color: #fff;
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

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: #d9534f;
            background-color: #f9f2f4;
            border: 1px solid #dab2b5;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .success-message {
            color: #5bc0de;
            background-color: #eef7fa;
            border: 1px solid #add9e4;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .table-container {
            flex: 2;
            width: calc(100% - 360px);
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
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

        @media screen and (max-width: 768px) {
            .container {
                flex-direction: column;
                align-items: center;
            }

            .form-container {
                margin-right: 0;
                margin-bottom: 20px;
                max-width: 100%;
            }

            .table-container {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<div class="top-bar">Student grading system</div>
<div class="container">
    <div class="form-container">
        <form action="/updateRecord" method="post">
            <input type="hidden" name="table" value="${table}">
            <div class="column-selection">
                <div class="column-option">
                    <input type="radio" name="columnChoice" value="1" id="column1" checked>
                    <label for="column1"><%= request.getAttribute("column1") %></label>
                </div>
                <div class="column-option">
                    <input type="radio" name="columnChoice" value="2" id="column2">
                    <label for="column2"><%= request.getAttribute("column2") %></label>
                </div>
            </div>
            <label for="idToUpdate">ID of the record to update:</label>
            <input type="text" name="idToUpdate" id="idToUpdate" required>
            <label for="newValue">New value:</label>
            <input type="text" name="newValue" id="newValue" required>

            <% String errorMessage = (String) request.getAttribute("errorMessage");
                String successMessage = (String) request.getAttribute("successMessage");
                if (errorMessage != null) { %>
            <div class="error-message"><%= errorMessage %></div>
            <% } else if (successMessage != null) { %>
            <div class="success-message"><%= successMessage %></div>
            <% } %>

            <button type="submit">Update Record</button>
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