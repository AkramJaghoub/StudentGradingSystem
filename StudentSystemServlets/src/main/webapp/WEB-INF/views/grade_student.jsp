<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add/Update Grade</title>
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

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }

        select, input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
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

        input[type="submit"] {
            background-color: cornflowerblue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 14px;
            transition: background-color 0.2s ease-in-out;
        }

        input[type="submit"]:hover {
            background-color: green;
        }

        .form-container {
            width: 100%;
            max-width: 400px;
        }

        .course-table-container {
            overflow: auto;
        }

        .course-table-container table {
            width: 100%;
        }

        .course-table-container td {
            cursor: pointer;
        }

        /* Add styles for table row hover effect */
        .course-table-container tr:hover {
            background-color: #f9f9f9;
            cursor: pointer;
        }

        @media screen and (max-width: 600px) {
            .container {
                flex-direction: column;
            }

            .right-column {
                margin-top: 20px;
            }
        }
        .selected-course {
            text-align: center;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .feedback-message {
            text-align: center;
            padding: 10px;
            font-weight: bold;
            margin-bottom: 10px;
            border-radius: 5px;
            max-width: 300px;
        }

        .left-column {
            flex: 0.8;
        }

        .right-column {
            flex: 1.2;
        }

        .feedback-message {
            border: 2px solid;
        }

        .form-container {
            margin: 20px auto; // example value, you can adjust as needed
        }

        .feedback-message.success {
            background-color: #4caf50;
            color: white;
            border-color: #4caf50;
        }

        .feedback-message.error {
            background-color: #f44336;
            color: white;
            border-color: #f44336;
        }

        .selected-course {
            text-align: center;
            font-weight: bold;
            margin-bottom: 20px;
        }


    </style>
    <script>
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
    </script>
</head>
<body>

<div class="container">

    <div class="left-column">
        <div class="left-column">
            <div class="form-container">
                <h2>Grade a Student</h2>
                <form method="post">

                    <label for="student_id">Student ID:</label>
                    <input type="number" id="student_id" name="student_id" placeholder="Enter Student ID" required>

                    <input id="course_id" type="hidden" name="course_id" value="${course_id}">

                    <input type="hidden" name="user_id" value="${user_id}">

                    <label for="grade">Grade:</label>
                    <input type="number" id="grade" name="grade" min="0" max="100" step="0.01" required>


                    <div style="display: flex; gap: 10px;">
                        <input type="submit" name="option" value="Add">
                        <input type="submit" name="option" value="Update">
                    </div>

                    <c:if test="${not empty feedbackMessage}">
                        <div class="feedback-message <c:choose><c:when test='${success}'>success</c:when><c:otherwise>error</c:otherwise></c:choose>"
                             style="text-align: center; margin-top: 10px;">
                                ${feedbackMessage}
                        </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>

    <div class="right-column">
        <h2>Courses</h2>
        <div class="selected-course" id="selectedCourse"></div>
        <div class="course-table-container">
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
        </div>

        <h2>Students</h2>
        <table id="studentsTable">
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
            </tr>
            <tr>
                <td colspan="2">Select a course to view students</td>
            </tr>
        </table>
    </div>
</div>


<script>
    function selectCourse(courseId) {
        document.getElementById("course_id").value = courseId;
        fetchStudents();
    }
</script>
</body>
</html>