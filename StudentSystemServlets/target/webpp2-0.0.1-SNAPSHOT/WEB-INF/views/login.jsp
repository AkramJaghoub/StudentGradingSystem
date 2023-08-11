<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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

        form {
            background: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 15px;
            margin-bottom: 15px;
            border: 1px solid #e1e1e1;
            border-radius: 5px;
            font-size: 16px;
            transition: border 0.3s ease;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 15px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        font[color="red"] {
            color: #ff4c4c;
            font-weight: bold;
        }

        /* Styling for labels */
        label {
            font-size: 16px;
            margin-bottom: 5px;
            display: block;
            text-align: left;
            color: #555;
            width: 100%;
        }

        /* Styling for error message */
        .error-message {
            background-color: #ff4c4c;
            color: white;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            width: 100%;
        }

        /* Flexbox styling for responsive layout */
        @media (max-width: 500px) {
            form {
                width: 90%;
            }
        }

        @media (max-width: 400px) {
            form {
                width: 80%;
            }
        }
        .role-selection {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }

        .role-option {
            display: flex;
            align-items: center;
            margin: 10px;
            position: relative;
        }

        .role-option input[type="radio"] {
            position: absolute;
            opacity: 0;
            width: 0;
            height: 0;
        }

        .role-option label {
            padding: 10px 20px;
            cursor: pointer;
            background-color: #eee;
            border: 2px solid #ddd;
            border-radius: 20px;
            transition: background 0.3s;
        }

        .role-option input[type="radio"]:checked + label {
            background-color: #007BFF;
            color: #fff;
        }

        .role-message {
            margin-bottom: 10px;
            color: #555;
            font-weight: bold;
            font-size: 18px;
            text-align: center;
            padding: 10px 20px;
            background-color: #f0db4f;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }


        #student:checked ~ .role-selection,
        #instructor:checked ~ .role-selection {
            display: none;
        }

        #student:checked ~ .role-message,
        #student:checked ~ .role-selection{

        }

    </style>
</head>

<body>
<div class="top-bar">Student grading system</div>
<form action="/login" method="POST">
    <div class="login-section">
        <div class="role-message">
            Please select your role:
        </div>
        <div class="role-selection">
            <div class="role-option">
                <input type="radio" id="student" name="role" value="STUDENT">
                <label for="student">Student</label>
            </div>
            <div class="role-option">
                <input type="radio" id="instructor" name="role" value="INSTRUCTOR">
                <label for="instructor">Instructor</label>
            </div>
        </div>
        <div class="login-fields">
            <!-- Error message styling -->
            <c:if test="${not empty errorMessage}">
                <div class="error-message">
                    <span>${errorMessage}</span>
                </div>
            </c:if>
            <label for="user_id">User ID:</label>
            <input id="user_id" name="user_id" type="text" required placeholder="Enter ID"/>
            <label for="password">Password:</label>
            <input id="password" name="password" type="password" placeholder="Enter Password" required/>
            <input type="submit" value="Login" />
        </div>
    </div>
</form>
</body>
</html>