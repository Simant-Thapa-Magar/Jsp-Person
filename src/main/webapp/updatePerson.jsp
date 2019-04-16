<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/15/2019
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Data</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/updateServlet" method="post">
<table>
    <tr>
        <td>ID</td>
        <td><input type="text" name="id" value="${person.id}" readonly/></td>
    </tr>
    <tr>
        <td>First Name</td>
        <td><input type="text" name="fname" value="${person.fname}"/></td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td><input type="text" name="lname" value="${person.lname}"/></td>
    </tr>
</table>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
