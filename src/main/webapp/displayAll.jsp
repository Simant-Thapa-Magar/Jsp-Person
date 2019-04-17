<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/14/2019
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<a href="${pageContext.request.contextPath}/addServlet?action=ADD" class="btn btn-success">Add new data</a>
<c:if test="${isTrue}">
    <div class="alert alert-success">
        <strong>Welcome!!!</strong>
    </div>
</c:if>
    <c:if test="${isSaved}">
    <div class="alert alert-success">
        <strong>Success!!</strong> ${message}
    </div>
</c:if>
<table width="100%" border="1px" align="center" class="table table-light">
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
            <td> <a href="${pageContext.request.contextPath}/updateServlet?id=${p.id}&action=UPDATE" class="btn btn-primary">Update</a>
                <a href="${pageContext.request.contextPath}/delServlet?id=${p.id}&action=DELETE" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>