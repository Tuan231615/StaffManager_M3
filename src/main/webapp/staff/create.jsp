<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/03/2023
  Time: 11:37 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new Staff</title>
    <style>
        .message {
            color: blue;
        }
    </style>
</head>
<h1>Create new staff</h1>
<p>
    <c:if test='${requestScope["message"] !=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/staffs">Back to staff list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Staff information</legend>
        <table>
            <tr>
                <td>Code</td>
                <td><input type="text" name="code" id="code"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
            <tr>
                <td>CCCD</td>
                <td><input type="number" name="cCCD" id="cCCD"/></td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><input type="number" name="phone" id="phone"/></td>
            </tr>
            <tr>
                <td>Address</td>
            <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"/></td>
            </tr>
            <tr>
                <td>Note</td>
                <td><input type="text" name="note" id="note"/></td>
            </tr>
            <tr>
                <td>Submit</td>
                <td><input type="submit" value="Create staff"></td>
            </tr>
        </table>
    </fieldset>
</form>
</html>
