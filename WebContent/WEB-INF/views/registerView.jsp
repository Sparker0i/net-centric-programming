<%--
  Created by IntelliJ IDEA.
  User: Sparker0i
  Date: 27-09-2018
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<div class="container">
<h3>Register User</h3>
<p style="color: red;">${errorString}</p>


<form method="POST" action="${pageContext.request.contextPath}/register">
    <table border="0">
        <tr>
            <td>User ID</td>
            <td><input type="text" name="userId" title="User ID" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" title="Password" /> </td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="confirmPassword" title="Confirm Password" /> </td>
        </tr>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" title="User Name" /> </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <select name="gender" id="gender">
                    <option value="0" selected>--Select--</option>
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>DOB</td>
            <td><input type="date" name="dob" title="Date of Birth" /> </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" title="Email Address" /> </td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" title="Phone Number" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
            </td>
        </tr>
    </table>
</form>
</div>

<jsp:include page="_footer.jsp"/>
</body>
</html>