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


<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/register">
        <div class="form-group">
            <label class="control-label col-sm-2" for="userId">User ID:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="userId" placeholder="User ID" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-3">
                <input type="password" class="form-control" id="password" placeholder="Password" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="confirmPassword">Confirm Password:</label>
            <div class="col-sm-3">
                <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="userName">User Name:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="userName" placeholder="User Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="gender">Gender:</label>
            <div class="col-sm-2">
                <select class="form-control" id="gender">
                    <option>Male</option>
                    <option>Female</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="dob">DOB:</label>
            <div class="col-sm-3">
                <input type="date" class="form-control" id="dob" placeholder="Date of Birth">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="email" placeholder="Email Address">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="phone">Phone:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="phone" placeholder="Phone Number">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
</form>
</div>

<jsp:include page="_footer.jsp"/>
</body>
</html>