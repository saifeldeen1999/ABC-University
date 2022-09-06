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
        /* Style inputs, select elements and textareas */
        input[type=text], select, textarea{
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            resize: vertical;
        }

        /* Style the label to display next to the inputs */
        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        /* Style the submit button */
        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        /* Style the container */
        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        /* Floating column for labels: 25% width */
        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        /* Floating column for inputs: 75% width */
        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
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
    <a href="/department/viewDepartments">Department Management System</a>
    <a href="/department/addDepartment">Add new Department</a>

</div>

<div>
    <table>
        <thead>
        <tr>
            <th>Course ID</th>
            <th>Title</th>
            <th>Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${departments}" var="dep">
            <tr>
                <td>${dep.id}</td>
                <td>${dep.title}</td>
                <td>
                    <a href="/department/editDepartment/${dep.id}">Edit</a>

                        <%--                    <form:form action="/department/deleteDepartment/${department.id}" method="delete">--%>
                        <%--                        <h:commandButton action="#{testBean.deleteAction()}" value="Submit" >Delete</h:commandButton>--%>
                        <%--                    </form:form>--%>

                    <a href="/department/viewDepartment/${dep.id}">View</a>
                    <a href="/department/deleteDepartment/${dep.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>