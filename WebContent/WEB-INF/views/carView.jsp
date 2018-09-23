<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
 	<br >
    Car ID: <b>${car.carId}</b>
    <br />
    Number Plate: <b>${car.numberPlate}</b>
    <br />
    Car: <b>${car.company} ${car.model} - ${car.version}</b>
    <br />
    Color: <b>${car.color}</b>
    <br />
    Fuel Type: <b>${car.fuelType}</b>
    <br />
    Gear Type: <b>${car.gearType}</b>
    <br />
    Has AC:
    <c:choose>
    	<c:when test='${car.ac}'><b>Yes</b></c:when>
    	<c:otherwise><b>No</b></c:otherwise>
    </c:choose>
    <br />
    Has Leather Seats:
    <c:choose>
    	<c:when test='${car.leatherSeats}'><b>Yes</b></c:when>
    	<c:otherwise><b>No</b></c:otherwise>
    </c:choose>
    <br />
    Has Sunroof:
    <c:choose>
    	<c:when test='${car.sunroof}'><b>Yes</b></c:when>
    	<c:otherwise><b>No</b></c:otherwise>
    </c:choose>
    <br />
    Car Type: <b>${car.carType}</b>
    <br />
    Cost Per Day: <b>${car.costPerDay}</b>
    <br />
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>