<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>

 <jsp:include page="_top.jsp"/>
 
    <h3>Hello: ${user.getUserId()}</h3>
 
    User ID: <b>${user.getUserId()}</b>
    <br />
 	User Name: <b>${user.getUserName()}</b>
    <br />
    Gender: <b>${user.getGender()}</b>
    <br />
    DOB: <b><fmt:formatDate pattern = "dd MMM yyyy" 
         value = "${user.getDob()}" /></b>
    <br />
    Email: <b>${user.getEmail()}</b>
    <br />
    Phone: <b>${user.getPhone()}</b>
    <br />
    <jsp:include page="_footer.jsp"/>
 
 </body>
</html>