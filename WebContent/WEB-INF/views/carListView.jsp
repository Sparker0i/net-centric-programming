<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car List</title>
</head>
<body>

<jsp:include page="_top.jsp"/>

<h3>Car List</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/">
    <input type="number" name="minPrice"  title="Minimum Price"/>
    <input type="number" name="maxPrice"  title="Maximum Price"/>
    <input type="submit" value= "Submit" />
</form>

<table border="1" cellpadding="5" cellspacing="1">
    <tr>
        <th>Car Name</th>
        <th>Cost Per Day</th>
        <th>Fuel Type</th>
        <th>Book Now</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.company} ${product.model}</td>
            <td>${product.costPerDay}</td>
            <td>${product.fuelType}</td>
            <td><a href="viewCar?CAR_ID=${product.carId}">Book Now</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>

</body>
</html>