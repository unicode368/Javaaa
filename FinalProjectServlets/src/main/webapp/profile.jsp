<%@ page import="com.example.faculty.model.entity.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.faculty.model.entity.User" %>
<%@ page import="com.example.faculty.model.entity.UserInfo" %>
<%@ page import="java.time.LocalDate" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <style>
        <%@include file="/css/profile.css"%>
        <%@include file="/css/logout.css"%>
    </style>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</head>
<%@ include file="fragments/language_buttons.jsp" %>
<%
    User user = (User) request.getSession().getAttribute("user");
    request.setAttribute("role", user.getRole().toString());
    UserInfo userInfo =
            (UserInfo) request.getAttribute("userInfo");
    ArrayList<Course> courseList = new ArrayList<>();
    if (user.getRole().toString().equals("user")) {
        request.setAttribute("role", user.getRole().toString());
        courseList = (ArrayList<Course>) request.getAttribute("userCourses");
    }
%>
<div class="logout-button">
<div class="navigation">
    <a class="button" href="logout">
        <div class="logout">LOGOUT</div>
    </a>
</div>
</div>
<div class="wrapper">
    <div class="left">
        <img src="https://i.imgur.com/cMy8V5j.png"
             alt="user" width="100">
        <h4><%=userInfo.getSurname()%></h4> <h4><%=userInfo.getName()%></h4>
        <h4><%=userInfo.getPatronimic()%></h4>
        <p><%=user.getUsername()%></p>
    </div>
    <div class="right">
        <div class="info">
            <h3>Information</h3>
            <div class="info_data">
                <div class="data">
                    <h4>Email</h4>
                    <p><%=userInfo.getEmail()%></p>
                </div>
                <div class="data">
                    <h4>Phone</h4>
                    <p><%=userInfo.getPhoneNumber()%></p>
                </div>
            </div>
        </div>
    </div>
</div>
<% if (user.getRole().toString().equals("admin")) { %>
<div class="button_cont" align="center">
    <a class="example_b" onclick="location.href='/admin/create-teacher'"
       target="_blank" rel="nofollow noopener noreferrer"
       draggable="false">Створення викладача</a></div>
<div class="button_cont" align="center">
    <a class="example_b2" href="#" onclick="location.href='/courses'"
       target="_blank"
       rel="nofollow noopener noreferrer"
       draggable="false">Редагування курсів</a></div>
<div class="button_cont" align="center">
    <a class="example_b3" target="_blank"
       onclick="location.href='/admin/users'"
       rel="nofollow noopener noreferrer"
       draggable="false">Блокування/розблокування користувачів</a></div>
<% } %>
<% if(courseList.size() > 0) {
    for (int i = 0; i < courseList.size(); i++) {
        if (LocalDate.parse(courseList.get(i)
                .getStartDate()).isAfter(LocalDate.now()) &&
        LocalDate.parse(courseList.get(i)
                .getEndDate()).isAfter(LocalDate.now())) { %>
<div>
    <div class="courses">Pending courses:</div>
    <div class="courses-list">
        <div>
            <h2><%=courseList.get(i).getName()%></h2>
            <h3><%=courseList.get(i).getTheme()%></h3>
            <p><%=courseList.get(i).getInfo()%></p>
            <h3><%=courseList.get(i).getStartDate()%></h3>
            <h3><%=courseList.get(i).getEndDate()%></h3>
            <div class="whitespace"></div>
        </div>
    </div>
    <% } %>
    <% } %>
    <% } %>
    <% if(courseList.size() > 0) {
        for (int i = 0; i < courseList.size(); i++) {
            if (LocalDate.parse(courseList.get(i)
                    .getStartDate()).isBefore(LocalDate.now()) &&
                    LocalDate.parse(courseList.get(i)
                            .getEndDate()).isAfter(LocalDate.now())) { %>
    <div class="courses">Ongoing courses:</div>
    <div class="courses-list">
        <div>
            <h2><%=courseList.get(i).getName()%></h2>
            <h3><%=courseList.get(i).getTheme()%></h3>
            <p><%=courseList.get(i).getInfo()%></p>
            <h3><%=courseList.get(i).getStartDate()%></h3>
            <h3><%=courseList.get(i).getEndDate()%></h3>
            <div class="whitespace"></div>
        </div>
    </div>
    <% } %>
    <% } %>
    <% } %>
 <!--   <div class="courses">Finished courses</div>
    <div class="courses-list">
        <div th:each="course, iterStat : ${courses}"
             th:if="${course.startDate.isBefore(localDate)
                                && course.endDate.isBefore(localDate)}">
            <h2 th:text="${course.name}"></h2>
            <h3 th:text="${course.theme}"></h3>
            <p th:text="${course.info}"></p>
            <h3 th:text="${course.startDate}"></h3>
            <h3 th:text="${course.endDate}"></h3>
            <h2>Оцінка</h2>
            <div th:if="${rates[iterStat.index] != null}">
                <h2 th:text="${rates[iterStat.index]}"></h2>
            </div>
            <div th:unless="${rates[iterStat.index] != null}">
                <h2 th:text="${no.grade}"></h2>
            </div>
            <div class="whitespace"></div>
        </div>
    </div>-->
</div>
<!--<a sec:authorize="hasAuthority('admin')"
   th:href="'/courses/' + ${course.id}">Переглянути</a>
<div sec:authorize="hasAuthority('teacher')" class="courses">My courses:</div>
-->
</html>
