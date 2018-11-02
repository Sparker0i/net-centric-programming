<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Info</title>
</head>
<body>

<jsp:include page="_top.jsp"/>
<br/>
<br/>
Number Plate: <b>${car.getNumberPlate()}</b>
<br/>
Car: <b>${car.getCompany()} ${car.getModel()} - ${car.getVersion()}</b>
<br/>
Color: <b>${car.getColor()}</b>
<br/>
Fuel Type: <b>${car.getFuelType()}</b>
<br/>
Gear Type: <b>${car.getGearType()}</b>
<br/>
Has AC:
<c:choose>
    <c:when test='${car.getAc()}'><b>Yes</b></c:when>
    <c:otherwise><b>No</b></c:otherwise>
</c:choose>
<br/>
Has Leather Seats:
<c:choose>
    <c:when test='${car.getLeatherSeats()}'><b>Yes</b></c:when>
    <c:otherwise><b>No</b></c:otherwise>
</c:choose>
<br/>
Has Sunroof:
<c:choose>
    <c:when test='${car.getSunroof()}'><b>Yes</b></c:when>
    <c:otherwise><b>No</b></c:otherwise>
</c:choose>
<br/>
Car Type: <b>${car.getCarType()}</b>
<br/>
Cost Per Day: <b>${car.getCostPerDay()}</b>
<br/>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/viewCar">
    <table border="1">
        <tr>
            <td>From: </td>
            <td><input type="date" name="fromDate" title="From"></td>
        </tr>
        <tr>
            <td>To: </td>
            <td><input type="date" name="toDate" title="To"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value= "Submit" /></td>
        </tr>
    </table>
</form>
<jsp:include page="_footer.jsp"/>

</body>
</html>