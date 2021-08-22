<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />
<!DOCTYPE html>
<html lang="${language}">
<head>
    <link rel="stylesheet" type="text/css" href="styles/login.css" />
</head>
<div class="wrapper">
    <form class="login" action="login" method="post">
        <p class="title"><fmt:message key="login.form.title" />:</p>
        <fmt:message key="login.form.username" var="username" />
        <input type="text" name="Username" placeholder="${username}" autofocus/>
        <i class="fa fa-user"></i>
        <input type="password" name="Password" placeholder="Password" />
        <i class="fa fa-key"></i>
<!--        <a href="#">Forgot your password?</a> -->
        <button>
            <i class="spinner"></i>
            <span class="state">Log in</span>
        </button>
    </form>
</div>
</html>