<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Create teacher</title>
    <link rel="stylesheet" href="/css/create-teacher.css" />
</head>
<body>
<form action="registration" method="POST">
    <div class="container">
        <h1>Register techer</h1>
        <p>Please fill in this form to create new teacher.</p>
        <hr>

        <label><b>Surname</b></label>
        <fmt:message key="registration.full.name.data" var="lastName"/>
        <input type="text" name="lastName" placeholder="${lastName}" required>
        <label><b>Name</b></label>
        <fmt:message key="registration.full.name.data" var="firstName"/>
        <input type="text" name="firstName" placeholder="${firstName}" required>
        <label><b>Patronimic</b></label>
        <fmt:message key="registration.full.name.data" var="patronimic"/>
        <input type="text" name="patronimic" placeholder="${patronimic}" required>
        <label><b>Username</b></label>
        <fmt:message key="registration.username.data" var="login"/>
        <input type="text" name="login" placeholder="${login}" required>
 <!--       <p th:each="error: ${fields.errors('login')}"
           th:text="${alogin.invalid}"></p>-->

        <label><b>Email</b></label>
        <fmt:message key="registration.email.data" var="email"/>
        <input type="text" name="email" placeholder="${email}" required>
 <!--       <p th:each="error: ${fields.errors('email')}"
           th:text="${emailrb.invalid}"></p>-->

        <label><b>Phone number</b></label>
        <fmt:message key="registration.phone.number.data" var="phoneNumber"/>
        <input type="text" name="phoneNumber" placeholder="${phoneNumber}" required>
<!--        <p th:each="error: ${gfields.errors('phoneNumber')}"
           th:text="#{mobile.phone.invalid}"></p>-->

        <label><b>Password</b></label>
        <fmt:message key="registration.password.data" var="password"/>
        <input type="password" name="password" placeholder="${password}" required>
<!--       <p th:each="error: ${gerfields.errors('global')}"
           th:text="${password.invalid}"></p>-->

        <label><b>Repeat Password</b></label>
        <fmt:message key="registration.confirm.password.data" var="matchingPassword"/>
        <input type="password" name="matchingPassword" placeholder="${matchingPassword}" required>
        <hr>

        <button type="submit" class="registerbtn">
            <input type="hidden" name="userRegisterRole" value="teacher">
        </button>
<!--        <div th:text="${userExists != null} ? #{user.exists}"></div>-->
    </div>
</form>
</body>
</html>