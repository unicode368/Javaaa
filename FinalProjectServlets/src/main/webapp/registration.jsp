<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/registration.css">
    <link rel="stylesheet" type="text/css" href="css/lang-buttons.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/registration.css"%>
    </style>
</head>
<body>
<%@ include file="fragments/language_buttons.jsp" %>
<div class="container">
    <div class="title">
        <fmt:message key="registration.title"/>
    </div>
    <div class="content">
        <form action="registration" method="POST" enctype="utf8">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.full.name"/>
                    </span>
                    <fmt:message key="registration.full.name.data" var="fullNameData"/>
                    <input type="text" name="lastName" id="lastName" placeholder="${fullNameData}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.full.name"/>
                    </span>
                    <fmt:message key="registration.full.name.data" var="fullNameData"/>
                    <input type="text" name="firstName" id="firstName" placeholder="${fullNameData}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.full.name"/>
                    </span>
                    <fmt:message key="registration.full.name.data" var="fullNameData"/>
                    <input type="text" name="patronimic" id="patronimic" placeholder="${fullNameData}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.username"/>
                    </span>
                    <fmt:message key="registration.username.data" var="login"/>
                    <input type="text" name="login" id="login" placeholder="${login}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.email"/>
                    </span>
                    <fmt:message key="registration.email.data" var="email"/>
                    <input type="text" name="email" id="email" placeholder="${email}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.phone.number"/>
                    </span>
                    <fmt:message key="registration.phone.number.data" var="phoneNumber"/>
                    <input type="text" name="phoneNumber" id="phoneNumber"
                           placeholder="${phoneNumber}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.password"/>
                    </span>
                    <fmt:message key="registration.password.data" var="password"/>
                    <input type="text" name="password" id="password" placeholder="${password}" required>
                </div>
                <div class="input-box">
                    <span class="details">
                        <fmt:message key="registration.confirm.password"/>
                    </span>
                    <fmt:message key="registration.password.data" var="matchingPassword"/>
                    <input type="text" name="matchingPassword" id="matchingPassword"
                           placeholder="${matchingPassword}" required>
                </div>
            </div>
            <div class="button">
                <fmt:message key="registration.submit" var="submit"/>
                <input type="submit" value="${submit}">
                <input type="hidden" name="userRegisterRole"
                       value="user">
            </div>
        </form>
    </div>
</div>
</body>
</html>