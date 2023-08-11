<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Read Records - ${table}</title>
    <style>
        /* Your CSS styling here (same as other JSP pages) */
        /* I am adding only the styles relevant to read_record.jsp */

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f4f4f4;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
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

        /* Table styling */
        .table-container {
            width: 70%;
            padding: 20px;
            border: 1px solid #ccc;
            overflow-x: auto;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

    </style>
</head>
<body>
<div class="top-bar">Student grading system</div>
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
</body>
</html>