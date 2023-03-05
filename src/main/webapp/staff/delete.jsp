<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05/03/2023
  Time: 11:02 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete staff</title>
</head>
<body>
<h1>Delete staff</h1>
<p>
    <a href="/staffs">Back to staff manager</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Staff information</legend>
        <table>
            <tr>
                <td>Code</td>
                <td>${requestScope["staff"].getCode()}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${requestScope["staff"].getName()}</td>
            </tr>
            <tr>
                <td>CCCD</td>
                <td>${requestScope["staff"].getcCCD()}</td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td>${requestScope["staff"].getPhone()}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${requestScope["staff"].getAddress()}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${requestScope["staff"].getEmail()}</td>
            </tr>
            <tr>
                <td>Note</td>
                <td>${requestScope["staff"].getNote()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete staff"></td>
                <td><a href="/staffs">Back to staff manager</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
