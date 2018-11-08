<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!--https://www.zastavki.com/pictures/originals/2017Auto___Volkswagen_Red_car_Volkswagen_Jetta_on_a_background_of_a_night_city_119383_.jpg -->
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h1>ZoomCar</h1>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">

        <!-- User store in session with attribute: loggedInUser -->
        <c:choose>
            <c:when test="${loggedInUser != null}">
                Hello <b>${loggedInUser.userName}</b>
                |
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </c:otherwise>
        </c:choose>
    </div>

</div>