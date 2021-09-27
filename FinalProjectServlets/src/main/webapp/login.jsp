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
    <form class="login" action="login" method="post">
        <p class="title"><fmt:message key="login.form.title" /></p>
        <fmt:message key="login.form.username" var="username" />
        <input type="text" name="Username" placeholder="${username}" autofocus/>
        <i class="fa fa-user"></i>
        <input type="password" name="Password" placeholder="Password" />
        <i class="fa fa-key"></i>
        <button>
            <i class="spinner"></i>
            <span class="state">Log in</span>
        </button>
    </form>
</div>
</html>