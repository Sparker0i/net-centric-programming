<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <title>User Info</title>
</head>
<body>

<jsp:include page="_menu.jsp"/>
<div class="container">
    <h3>Hello: ${user.getUserId()}</h3>
    <div class="row col-md-6 col-md-offset-3" style="margin-top: 40px;">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>User ID:</td>
                    <td><b>${user.getUserId()}</b></td>
                </tr>
            </thead>
            <tr>
                <td>User Name:</td>
                <td><b>${user.getUserName()}</b></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><b>${user.getGender()}</b></td>
            </tr>
            <tr>
                <td>DOB:</td>
                <td><b><fmt:formatDate pattern="dd MMM yyyy" value="${user.getDob()}"/></b></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><b>${user.getEmail()}</b></td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td><b>${user.getPhone()}</b></td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="_footer.jsp"/>
</body>
</html>