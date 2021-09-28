<%@ page import="com.example.faculty.model.entity.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.faculty.model.entity.User" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.faculty.model.entity.UserInfo" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Courses</title>
    <style>
        <%@include file="/css/courses.css"%>
    </style>
</head>
<style>

    #navlist a {
        float:left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 12px;
        text-decoration: none;
        font-size: 15px;
    }

    .navlist-right{
        float:right;
    }

    /* hover effect of navlist anchor element */
    #navlist a:hover {
        background-color: #ddd;
        color: black;
    }

    /* styling search bar */
    .search input[type=text]{
        width:300px;
        height:25px;
        border-radius:25px;
        border: none;
    }

    .search{
        float:right;
        margin:7px;
    }

    .search button{
        background-color: #0074D9;
        color: #f2f2f2;
        float: right;
        padding: 5px 10px;
        margin-right: 16px;
        font-size: 12px;
        border: none;
        cursor: pointer;
    }
</style>
<body>
<%@ include file="fragments/language_buttons.jsp" %>
<div class="search">
    <form
          onsubmit="setGetParameter('search-by', $('#search-by option:selected').val())">
        <select name="sort" id="sort" onchange="setGetParameter('sort', this.value)">
            <option selected disabled>Choose here</option>
            <option value="nameASC">назва (A-Z)</option>
            <option value="nameDESC">назва (Z-A)</option>
            <option value="duration">тривалість</option>
            <option value="studentAmount">к-сть студентів</option>
        </select>
        <select name="search-by" id="search-by" style="float: right">
            <option selected disabled>Choose here</option>
            <option value="theme">тема</option>
            <option value="teacher">викладач</option>
        </select>
        <input type="text"
               placeholder=" Search Courses"
               name="searchName" id="searchName">
        <button type="submit">
            <i class="fa fa-search"
               style="font-size: 18px;">
            </i>
        </button>
    </form>
</div>
<%
    ArrayList<Course> courseList = (ArrayList<Course>) request.getAttribute("courses");
    ArrayList<ArrayList<User>> users =
            (ArrayList<ArrayList<User>>) request.getAttribute("users");
    ArrayList<UserInfo> teachers =
            (ArrayList<UserInfo>) request.getAttribute("teachers");
    User user = (User) request.getSession(false).getAttribute("user");
    if(courseList != null && courseList.size() > 0) {
        for (int i = 0; i < courseList.size(); i++) {
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
            <h3
                th:text="${course.teacher.getUserInfo().toString()}">
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
</div>
<%         } %>
<%      } %>
<% } %>
<!--<div sec:authorize="hasAuthority('admin')" class="courses-list">
    <div class="one_course"
         th:each="course : ${courses}">
        <h2 style="align-content: center;
            margin: 10px; display: grid" th:text="${course.name}"></h2>
        <div class="field">
            <span >Тема: </span>
            <h2
                    th:text="${course.theme}"></h2>
        </div>
        <div class="field">
            <span>Інформація про курс: </span>
            <p th:text="${course.info}"></p>
        </div>
        <div class="field">
            <span >Початок: </span>
            <h3  th:text="${course.startDate}"></h3>
        </div>
        <div class="field">
            <span>Кінець: </span>
            <h3 th:text="${course.endDate}"></h3>
        </div>
        <div class="field">
            <span >Викладач: </span>
            <h3
                    th:text="${course.teacher.getUserInfo().toString()}"></h3>
        </div>
        <div class="field">
            <span >К-сть студентів: </span>
            <h3 th:text="${course.students.size()}"></h3>
        </div>
        <a th:href="'/admin/courses/' + ${course.id} + '/edit'">Редагувати</a>
        <form th:action="@{/admin/courses/} + ${course.id} + @{/delete}"
              method="POST">
            <button type="submit">Видалити</button>
        </form>
        <div class="whitespace"></div>
    </div>
    <a th:href="'/admin/create-course'">Додати</a>
</div>-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<script>
    function setGetParameter(paramName, paramValue)
    {
        var url = window.location.href;
        var hash = location.hash;
        url = url.replace(hash, '');
        if (url.indexOf(paramName + "=") >= 0)
        {
            var prefix = url.substring(0, url.lastIndexOf(paramName + "="));
            var suffix = url.substring(url.lastIndexOf(paramName + "="));
            suffix = suffix.substring(suffix.lastIndexOf("=") + 1);
            suffix = (suffix.indexOf("&") >= 0) ? suffix.substring(suffix.lastIndexOf("&")) : "";
            url = prefix + paramName + "=" + paramValue + suffix;
        }
        else
        {
            if (url.indexOf("?") < 0)
                url += "?" + paramName + "=" + paramValue;
            else
                url += "&" + paramName + "=" + paramValue;
        }
        window.location.href = url + hash;
    }
    function setSearchParams(paramName1, paramName2,
                             paramValue1, paramValue2) {
        setGetParameter(paramName1, paramValue1);
        setGetParameter(paramName2, paramValue2);
    }
</script>
</body>
</html>