<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
       	  <th>Car ID</th>
          <th>Car Name</th>
          <th>Cost Per Day</th>
          <th>Fuel Type</th>
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
          	 <td><a href="viewCar?CAR_ID=${product.carId}">${product.carId}</a></td>
             <td>${product.company} ${product.model}</td>
             <td>${product.costPerDay}</td>
             <td>${product.fuelType}</td>
          </tr>
       </c:forEach>
    </table>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>