<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05/03/2023
  Time: 10:23 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Staff</title>
</head>
<body>
<h1>Edit to staff</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="${pageContext.request.contextPath}/staffs">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <lengend>
            Staff information
        </lengend>
        <table>
            <tr>
                <td>Code</td>
                <td><input type="text" name="code" id="code" value="${requestScope["staff"].getCode()}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${requestScope["staff"].getName()}"></td>
            </tr>
            <tr>
                <td>CCCD</td>
                <td><input type="number" name="cCCD" id="cCCD" value="${requestScope["staff"].getcCCD()}"></td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><input type="number" name="phone" id="phone" value="${requestScope["staff"].getPhone()}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" id="address" value="${requestScope["staff"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email" value="${requestScope["staff"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Note</td>
                <td><input type="text" name="note" id="note" value="${requestScope["staff"].getNote()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update staff"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
