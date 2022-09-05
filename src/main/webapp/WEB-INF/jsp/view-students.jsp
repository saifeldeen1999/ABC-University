<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #04AA6D;
            color: white;
        }

        th {
            background-color: #04AA6D;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: lightslategrey;
        }

        th, td {
            border-bottom: 1px solid #ddd;
            padding: 15px;
            text-align: left;
        }



    </style>
</head>
<body>
<div class="topnav">
    <a class="active" href="/home/viewData">Home</a>
    <a href="/student/viewStudents">Student Management System</a>
    <a href="/student/addStudent">Add new Student</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.email}</td>
                <td>
                    <button href="/student/editStudent">Edit</button>
                    <button href="/student/deleteStudent">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>