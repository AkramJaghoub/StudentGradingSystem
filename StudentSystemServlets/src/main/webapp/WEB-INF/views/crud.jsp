<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>CRUD Operations for <%= request.getAttribute("table") %></title>
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
<h3><%= request.getAttribute("table") %> Table</h3>
<table>
    <tr>
        <th>Action</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>
            <form action="/addRecord" method="GET">
                <input type="hidden" name="action" value="create">
                <input type="hidden" name="table" value="<%= request.getAttribute("table") %>">
                <button type="submit">Create</button>
            </form>
        </td>
        <td class="description">Add a new record to the <%= request.getAttribute("table") %> table.</td>
    </tr>
    <tr>
        <td>
            <form action="/readRecords" method="GET">
                <input type="hidden" name="action" value="read">
                <input type="hidden" name="table" value="<%= request.getAttribute("table") %>">
                <button type="submit">Read</button>
            </form>
        </td>
        <td class="description">View all records in the <%= request.getAttribute("table") %> table.</td>
    </tr>
    <tr>
        <td>
            <form action="/updateRecord" method="GET">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="table" value="<%= request.getAttribute("table") %>">
                <button type="submit">Update</button>
            </form>
        </td>
        <td class="description">Modify a record in the <%= request.getAttribute("table") %> table.</td>
    </tr>
    <tr>
        <td>
            <form action="/deleteRecord" method="GET">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="table" value="<%= request.getAttribute("table") %>">
                <button type="submit">Delete</button>
            </form>
        </td>
        <td class="description">Remove a record from the <%= request.getAttribute("table") %> table.</td>
    </tr>
</table>
</body>
</html>