<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/18/2019
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp?"/>
<div style="text-align:center">
    <Strong>Sign up form</Strong>
</div>
<br>
<form action="userController?action=signup" id="signupform" method="post">
<table class="table table-light">
    <tr>
        <td>Id</td>
        <td><input type="text" name="id"/></td>
    </tr>
    <tr>
        <td>First Name</td>
        <td><input type="text" name="fname"/></td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td><input type="text" name="lname"/></td>
    </tr>
    <tr>
        <td>Contact</td>
        <td><input type="text" name="contact"/></td>
    </tr>
    <tr>
        <td>Username</td>
        <td><input type="text" name="username"/></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="password" name="password" id="password"/></td>
    </tr>
    <tr>
        <td>Confirm Password</td>
        <td><input type="password" name="cpassword"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Sign Up" class="btn btn-primary"/></td>
    </tr>
</table>
</form>
<script>
$('#signupform').validate({
    rules:{
        id:{
            required: true,
            number: true
        },
        fname:{
            required: true
        },
        lname:{
            required: true
        },
        contact:{
            required:true
        },
        username:{
            required:true
        },
        password:{
            required: true
        },
        cpassword:{
            required: true,
            equalTo: "#password"
        }
    },
    messages:{
        id:"Id cannot be blank",
        fname:"First name cannot be blank",
        lname:"Last name cannot be blank",
        contact:"Contact cannot be blank",
        username:"Username cannot be blank",
        password:"Password cannot be blank",
        cpassword:{
            required:"Cannot accept empty field",
            equalTo:"Must be same as password"}
    }
})
</script>
<jsp:include page="footer.jsp"/>