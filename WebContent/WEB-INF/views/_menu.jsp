<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <c:choose>
                <c:when test="${loggedInUser != null}">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">ZoomCar</a>
                </c:when>
                <c:otherwise>
                    <a class="navbar-brand">ZoomCar</a>
                </c:otherwise>
            </c:choose>
        </div>
        <c:choose>
            <c:when test="${loggedInUser != null}">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/orders">View Orders</a></li>
                    <li><a href="${pageContext.request.contextPath}/userInfo">My Account Info</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a>Hello, <b>${loggedInUser.getUserName()}</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
            </c:when>
        </c:choose>
    </div>
</nav>