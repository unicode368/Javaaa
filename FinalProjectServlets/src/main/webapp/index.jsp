<%@ page import="com.example.faculty.model.entity.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.faculty.model.entity.User" %>
<%@ page import="com.example.faculty.model.entity.UserInfo" %>
<%@ page import="java.time.LocalDate" %>
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
    <%
        ArrayList<Course> courseList = (ArrayList<Course>) request.getAttribute("courses");
        ArrayList<ArrayList<User>> users =
                (ArrayList<ArrayList<User>>) request.getAttribute("users");
        ArrayList<UserInfo> teachers =
                (ArrayList<UserInfo>) request.getAttribute("teachers");
        User user = (User) request.getSession(false).getAttribute("user");
        if (user == null) {
            request.setAttribute("role", "unauthorized");
        } else {
            request.setAttribute("role", user.getRole().toString());
        }
        if(courseList != null && courseList.size() > 0) {
            for (int i = 0; i < 2; i++) {
                if (LocalDate.parse(courseList.get(i).getEndDate())
                        .isAfter(LocalDate.now())) {
    %>
    <div class="courses-list">
        <div class="one_course">
            <h2 style="align-content: center; margin: 10px; display: grid">
                <%=courseList.get(i).getName()%>
            </h2>
            <div class="field">
                <span ><fmt:message key="course.theme" /></span>
                <h2>
                    <%=courseList.get(i).getTheme()%>
                </h2>
            </div>
            <div class="field">
                <span><fmt:message key="course.info" /> </span>
                <p><%=courseList.get(i).getInfo()%></p>
            </div>
            <div class="field">
                <span ><fmt:message key="course.start" /> </span>
                <h3><%=courseList.get(i).getStartDate()%></h3>
            </div>
            <div class="field">
                <span><fmt:message key="course.end" /></span>
                <h3><%=courseList.get(i).getEndDate()%></h3>
            </div>
            <div class="field">
                <span ><fmt:message key="course.teacher" /></span>
                <h3>
                    <%=teachers.get(i).toString()%>
                </h3>
            </div>
            <div class="field">
                <span ><fmt:message key="course.student.number" /></span>
                <h3>
                    <%=users.get(i).size()%>
                </h3>
            </div>
            <!--<a href="'/courses/' + ${course.id}">Переглянути</a>-->
        </div>
        <%          } %>
        <%      } %>
        <% } %>
        <a href="courses">Більше курсів</a>
    </div>
</div>
</body>
</html>