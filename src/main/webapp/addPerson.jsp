<%--
  Created by IntelliJ IDEA.
  User: nytde
  Date: 4/15/2019
  Time: 7:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/addServlet?action=ADD" method="post">
<table class="table thead-light form-group">
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
    <tr>
   <td> <input type="submit" value="Add Person" class="btn btn-primary">
   </td></tr>
</table>
</form>
<script>
    $('#addPerson.jsp').validate({
        rules: {
            fname:{
                required: true
            },
            lname: {
                required: true
            },
            id:{
                required: true,
                number: true,
                minlength: 1,
                maxlength: 3
            }
        },
        messages:{
            fname: "Please enter first name",
            lname: "Please enter last name",
            id: "Please enter valid age"
        }
    })
</script>
<jsp:include page="footer.jsp"/>