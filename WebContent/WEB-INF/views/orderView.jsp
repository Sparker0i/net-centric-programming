<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

<jsp:include page="_top.jsp"/>

<h3>Product List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Car ID</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Request Date</th>
    </tr>
    <c:forEach items="${transactions}" var="transaction" >
        <tr>
            <td><a href="viewCar?CAR_ID=${transaction.carId}">${transaction.carId}</a></td>
            <td><fmt:formatDate pattern = "dd MMM yyyy" value = "${transaction.startDate}" /></td>
            <td><fmt:formatDate pattern = "dd MMM yyyy" value = "${transaction.endDate}" /></td>
            <td><fmt:formatDate pattern = "dd MMM yyyy" value = "${transaction.dateOfRequest}" /></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>

</body>
</html>