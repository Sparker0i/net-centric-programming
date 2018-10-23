<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div style="background: #E0E0E0; padding-top: 20px; padding-left: 10px;">
    <c:if test="${loggedInUser != null}">
        <a href="${pageContext.request.contextPath}/">Home</a>
        |
        <a href="${pageContext.request.contextPath}/orders">View Orders</a>
        |
        <a href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
    </c:if>
</div>