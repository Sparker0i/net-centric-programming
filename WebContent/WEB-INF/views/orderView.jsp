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

<jsp:include page="_menu.jsp"/>

<h3>Product List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Car</th>
        <th>Version</th>
        <th>Request Date</th>
        <th>Cost Per Day</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Total Cost</th>
    </tr>
    <c:forEach items="${transactions}" var="transaction" >
        <tr>
            <td><a href="viewCar?CAR_ID=${transaction.getCarId()}">${transaction.getCompany()} ${transaction.getModel()}</a></td>
            <td>${transaction.getVersion()}</td>
            <td><fmt:formatDate pattern = "dd MMM yyyy" value = "${transaction.getDateOfRequest()}" /></td>
            <td>${transaction.getCostPerDay()}</td>
            <td><fmt:formatDate pattern = "dd MMM yyyy" value = "${transaction.getStartDate()}" /></td>
            <td><fmt:formatDate pattern = "dd MMM yyyy" value = "${transaction.getEndDate()}" /></td>
            <td>${transaction.getCost()}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>

</body>
</html>