<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;

        }

        tr:hover {background-color: lightslategrey;}
        /*tr:nth-child(even) {background-color: #f2f2f2;}*/

        th {
            background-color: #04AA6D;
            color: white;
        }
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
    <a href="/department/viewDepartment">Department Management System</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>Department ID</th>
            <th>Department Title</th>

        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${department.id}</td>
                <td>${department.title}</td>

            </tr>
        </tbody>
    </table></div>
</body>

</html>