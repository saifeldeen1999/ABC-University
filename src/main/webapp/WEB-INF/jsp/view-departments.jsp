<!DOCTYPE html>
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
    </style>
</head>

<body>

<div class="topnav">
    <a class="active" href="/home/viewData">Home</a>
    <a href="/student/viewDepartments">Department Management System</a>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>Title</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${departments}" var="dep">
            <tr>
                <td>${dep.title}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>