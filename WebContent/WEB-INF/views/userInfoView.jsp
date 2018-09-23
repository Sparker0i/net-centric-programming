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
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Hello: ${user.userId}</h3>
 
    User ID: <b>${user.userId}</b>
    <br />
 	User Name: <b>${user.userName}</b>
    <br />
    Gender: <b>${user.gender}</b>
    <br />
    DOB: <b><fmt:formatDate pattern = "dd MMM yyyy" 
         value = "${user.dob}" /></b>
    <br />
    Email: <b>${user.email}</b>
    <br />
    Phone: <b>${user.phone}</b>
    <br />
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>