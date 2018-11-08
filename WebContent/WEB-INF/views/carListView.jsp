<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <title>Car List</title>
</head>
<body>

<jsp:include page="_top.jsp"/>

<div class="container">
<h3>Car List</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/">
    <div class="form-group col-xs-5">
        <input type="number" name="minPrice" id="minPrice" title="Minimum Price" class="form-control" required="true"
               placeholder="Minimum Price"/>
    </div>
    <div class="form-group col-xs-5">
        <input type="number" name="maxPrice" id="maxPrice" title="Maximum Price" class="form-control" required="true"
               placeholder="Maximum Price"/>
    </div>
    <button type="submit" class="btn btn-danger">
        <span class="glyphicon glyphicon-search"></span> Search
    </button>
</form>
</div>

<table class="table table-striped">
    <thead>
        <tr>
            <td>Car Name</td>
            <td>Cost Per Day</td>
            <td>Fuel Type</td>
            <td>Book Now</td>
        </tr>
    </thead>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.getCompany()} ${product.getModel()}</td>
            <td>${product.getCostPerDay()}</td>
            <td>${product.getFuelType()}</td>
            <td><a href="viewCar?CAR_ID=${product.getCarId()}">Book Now</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>

</body>
</html>