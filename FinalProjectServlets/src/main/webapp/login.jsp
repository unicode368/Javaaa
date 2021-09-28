<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="/css/login.css"%>
    </style>
</head>
<div class="wrapper">
    <form class="login" action="login" method="POST">
        <p class="title"><fmt:message key="login.form.title" /></p>
        <fmt:message key="login.form.username" var="username" />
        <input type="text" name="login" id="login" placeholder="${username}" autofocus/>
        <i class="fa fa-user"></i>
        <input type="password" name="password" id="password" placeholder="Password" />
        <i class="fa fa-key"></i>
        <% if (request.getAttribute("loginError") != null &&
            request.getAttribute("loginError").equals("wrong.credentials")) {%>
        <div style="color: red"><fmt:message key="wrong.credentials"/></div>
        <% } else if (request.getAttribute("loginError") != null &&
                request.getAttribute("loginError").equals("user.blocked")) {%>
        <div style="color: red"><fmt:message key="user.blocked"/></div>
        <%}%>
        <button>
            <i class="spinner"></i>
            <span class="state">Log in</span>
        </button>
    </form>
    <%@ include file="fragments/language_buttons.jsp" %>
</div>
</html>