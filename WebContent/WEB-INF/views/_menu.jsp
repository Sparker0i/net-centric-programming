<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ZoomCar</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/orders">View Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/userInfo">My Account Info</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${loggedInUser != null}">
                    <li><a href="#">Hello, <b>${loggedInUser.userName}</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>