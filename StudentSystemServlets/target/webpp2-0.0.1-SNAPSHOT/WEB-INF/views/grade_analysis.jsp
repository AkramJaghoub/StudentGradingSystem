<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Grade Analysis</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            gap: 20px;
            padding: 30px;
        }
        .left-column {
            flex: 1;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            padding: 20px;
        }
        .right-column {
            flex: 1;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            padding: 20px;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f9f9f9;
            cursor: pointer;
        }
        .selected-course {
            text-align: center;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
    <script>

        function selectCourse(courseId) {
            document.getElementById("course_id").value = courseId;
            fetchStudents();
            fetchGradeAnalysis(courseId);
        }


        function fetchStudents() {
            const courseId = document.getElementById("course_id").value;
            console.log("Course ID:", courseId); // Log course ID
            const studentsTable = document.getElementById("studentsTable");
            if (courseId !== "") {
                const xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                            console.log("Received response:", xhr.responseText);
                            studentsTable.innerHTML = xhr.responseText;
                        } else {
                            console.error("Error fetching students data:", xhr.status, xhr.statusText);
                        }
                    }
                };
                xhr.open("GET", "/fetchStudents?course_id=" + courseId, true);
                xhr.send();
                document.getElementById("selectedCourse").textContent = "Viewing Course ID: " + courseId;
            } else {
                studentsTable.innerHTML = "<tr><td colspan='2'>Select a course to view students</td></tr>";
                document.getElementById("selectedCourse").textContent = "";
            }
        }

        function fetchGradeAnalysis(courseId) {
            const analysisTable = document.getElementById("analysisTable");
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        console.log("Received grade analysis response:", xhr.responseText);
                        analysisTable.innerHTML = xhr.responseText;
                    } else {
                        console.error("Error fetching grade analysis data:", xhr.status, xhr.statusText);
                    }
                }
            };
            xhr.open("GET", "/fetchGradeAnalysis?course_id=" + courseId, true);
            xhr.send();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="left-column">
        <h2>Grade Analysis</h2>
        <table id="analysisTable">
            <tr>
                <th>Criteria</th>
                <th>Value</th>
            </tr>
            <c:forEach var="entry" items="${gradeAnalysis}">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="right-column">
        <h2>Courses</h2>
        <div class="selected-course" id="selectedCourse"></div>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>No. of Students</th>
            </tr>
            <c:forEach var="entry" items="${courses}">
                <tr onclick="selectCourse('${entry.key}')">
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                    <td>${studentsCount[entry.key]}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>Students</h2>
        <table id="studentsTable">
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Grade</th>
            </tr>
            <tr>
                <td colspan="3">Select a course to view students</td>
            </tr>
        </table>
    </div>
</div>
<input id="course_id" type="hidden" name="course_id">
</body>
</html>