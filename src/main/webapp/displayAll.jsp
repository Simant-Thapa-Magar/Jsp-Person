<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/14/2019
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class=" container">
<a href="${pageContext.request.contextPath}/addPerson.jsp" class="btn btn-success">Add new data</a>
<c:if test="${isTrue}">
    <div class="alert alert-success">
        <strong>Welcome!!!</strong>
    </div>
</c:if>
    <c:if test="${isSaved}">
    <div class="alert alert-success">
        <strong>Success!!</strong> Operation successful...
    </div>
</c:if>
</div>
<table width="100%" border="1px">
<tr bgcolor="#a9a9a9">
    <td>Id</td>
    <td>First Name</td>
    <td>Last Name</td>
    <td>Action</td>
</tr>
    <c:forEach items="${personList}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.fname}</td>
            <td>${p.lname}</td>
            <td> <a href="${pageContext.request.contextPath}/updateServlet?id=${p.id}" class="btn btn-warning">Update</a>
                <a href="${pageContext.request.contextPath}/delServlet?id=${p.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
