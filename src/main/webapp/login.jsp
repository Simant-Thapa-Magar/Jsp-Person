<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/18/2019
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/><br>
<div style="text-align:center">
    <Strong> Login Here!</Strong>
</div>
<c:if test="${isTrue}">
    <div class="alert alert-success">
        Registered !! Please enter your credentials to proceed...
    </div>
</c:if>
<form action="userController?action=login" method="post" id="login">
    <table class="table table-light">
        <input type="hidden" name="action" value="login"/>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="login" class="btn btn-primary"/></td>
        </tr>
        <tr>
            <td> <a href="signup.jsp?title=SignUp" class="btn btn-success" >Sign Up!!</a></td>
        </tr>
    </table>
</form>
<script>
    $('#login').validate({
        rules:{
            username:{
                required:true
            },
            password:{
                required: true
            }
        },
        messages:{
          username: "Cannot accept empty username field",
          password:"Cannot accept empty password field"
        }
    })
</script>
<jsp:include page="footer.jsp"/>