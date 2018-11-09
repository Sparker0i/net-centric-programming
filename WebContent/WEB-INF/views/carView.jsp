<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <title>Car Info</title>
</head>
<body>
<style>
    .container-large {
        max-width: 100%;
    }
</style>
<jsp:include page="_menu.jsp"/>
<div class="container-large" style="padding-top: 40px;">
    <div class="row">
        <div class="col-xs-4 col-md-4 col-md-offset-1 item-photo">
            <img height="240px" width="320px" src="${car.getImageUrl()}" />
        </div>
        <div class="col-xs-5 col-md-3" style="border:0px solid gray">
            <!-- Datos del vendedor y titulo del producto -->
            <h3>${car.getModel()} - ${car.getVersion()} (${car.getColor()})</h3>
            <h5 style="color:#337ab7">${car.getCompany()}</h5>

            <!-- Precios -->
            <h3 style="margin-top:0px;">₹ ${car.getCostPerDay()}</h3>

            <!-- Detalles especificos del producto -->
            <div class="section" style="padding-bottom:5px;">
                <h6 class="title-attr"><small>${car.getNumberPlate()}</small></h6>
                <div>
                    <div class="attr2">Fuel Type: ${car.getFuelType()}</div>
                    <div class="attr2">Gear Type: ${car.getGearType()}</div>
                    <div class="attr2">Has AC:
                        <c:choose>
                            <c:when test='${car.getAc()}'><strong>Yes</strong></c:when>
                            <c:otherwise><strong>No</strong></c:otherwise>
                        </c:choose>
                    </div>
                    <div class="attr2">Has Leather Seats:
                        <c:choose>
                            <c:when test='${car.getLeatherSeats()}'><strong>Yes</strong></c:when>
                            <c:otherwise><strong>No</strong></c:otherwise>
                        </c:choose>
                    </div>
                    <div class="attr2">Has Sunroof:
                        <c:choose>
                            <c:when test='${car.getSunroof()}'><b>Yes</b></c:when>
                            <c:otherwise><b>No</b></c:otherwise>
                        </c:choose>
                    </div>
                    <div class="attr2">Car Type: ${car.getCarType()}</div>
                </div>
            </div>
        </div>
        <form class="form-horizontal col-md-3" style="padding-top: 20px;" method="POST" action="${pageContext.request.contextPath}/viewCar">
            <div class="form-group">
                <label class="control-label col-sm-2" for="fromDate">From:</label>
                <div class="col-md-8">
                    <input type="date" class="form-control" name="fromDate" id="fromDate" title="From">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="toDate">To:</label>
                <div class="col-md-8">
                    <input type="date" class="form-control" name="toDate" id="toDate" title="From">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Book</button>
                </div>
            </div>
        </form>
    </div>
</div>
<br/>
<br/>
<br/>

<p style="color: red;">${errorString}</p>

<jsp:include page="_footer.jsp"/>

</body>
</html>