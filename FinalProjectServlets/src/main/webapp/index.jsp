<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <style>
        <%@include file="/css/home.css"%>
    </style>
</head>
<body>
<div class="header">
    <div class="header__bg"></div>
    <h1 class="header__title">
        <fmt:message key="home.greeting"/>
    </h1>
    <div class="header__log" >
        <%@ include file="fragments/language_buttons.jsp" %>
        <svg class="header__log--icon" width="24" height="24" viewBox="0 0 24 24">
            <path d="M12,4A4,4 0 0,1 16,8A4,4 0 0,1 12,12A4,4 0 0,1 8,8A4,4 0 0,1 12,4M12,14C16.42,14 20,15.79 20,18V20H4V18C4,15.79 7.58,14 12,14Z"></path>
        </svg>
    </div>
</div>

<div class="about">
    <div class="about__title">
        <h2 class="about__title--text">
            <c:if test="${!pageContext.request.isUserInRole('guest')}">
                <fmt:message key="home.options"/>
            </c:if>
        </h2>
    </div>
    <div class="about__text">
        <c:if test="${!pageContext.request.isUserInRole('user')}">
            <a href="login">
                <fmt:message key="home.option1"/>
            </a>
        </c:if>
        <c:if test="${!pageContext.request.isUserInRole('user')}">
            <a href="registration">
                <fmt:message key="home.option2"/>
            </a>
        </c:if>
    </div>
</div>
</body>
</html>