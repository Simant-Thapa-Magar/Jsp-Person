<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/15/2019
  Time: 7:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Person</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addServlet&action=ADD">
<table>
    <tr>
        <td>Id </td>
        <td><input type="text" name="id"></td>
    </tr>
    <tr>
        <td>First Name </td>
        <td><input type="text" name="fname"></td>
    </tr>
    <tr>
    <td>Last Name </td>
    <td><input type="text" name="lname"></td>
    </tr>
</table>
    <input type="submit" value="Submit">
</form>
</body>
</html>
