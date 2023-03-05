<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03/03/2023
  Time: 3:47 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Staff Manager List</title>
</head>
<body>
<p>
    <a href="/staffs?action=create">Create New Staff</a>
</p>
<table border="1">
    <tr>
        <td>Code</td>
        <td>Name</td>
        <td>CCCD</td>
        <td>Phone number</td>
        <td>Address</td>
        <td>Email</td>
        <td>Note</td>
    </tr>
<c:forEach items='${requestScope["staffs"]}' var="staff">
    <tr>
        <td><a href="/staffs?action=view&id=${staff.getId()}">${staff.getCode()}</a></td>
        <td>${staff.getName()}</td>
        <td>${staff.getcCCD()}</td>
        <td>${staff.getPhone()}</td>
        <td>${staff.getAddress()}</td>
        <td>${staff.getEmail()}</td>
        <td>${staff.getNote()}</td>
        <td><a href="/staffs?action=edit&id=${staff.getId()}">edit</a></td>
        <td><a href="/staffs?action=delete&id=${staff.getId()}">delete</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
