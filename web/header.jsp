<%@ page import="webapp.dbutils.Validate" %>
<%@ page import="webapp.entities.UsersEntity" %>
<%@ page import="webapp.dbutils.SessionKeys" %><%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 26.03.2018
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="css/style39.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="outer">
    <div id="header">
        <div id="logo">
            <h1>
                <a href="index.jsp">Aware</a>
            </h1>
        </div>
        <div id="nav">
            <ul>
                <%
                    if (request.getSession(true)
                        .getAttribute(SessionKeys.USER_INFO) == null) {
                %>
                <li class="first">
                    <a href="login.jsp"> Вход </a>
                </li>
                <li>
                    <a href="registration.jsp"> Регистрация </a>
                </li>
                <li>
                    <a href="about.jsp">О нас</a>
                </li>
                <li class="last">
                    <a href="contacts.jsp">Контакты</a>
                </li>
                <%
                } else {
                %>
                <li class="first">
                    <a href="about.jsp">О нас</a>
                </li>
                <li>
                    <a href="contacts.jsp">Контакты</a>
                </li>
                <li class="last">
                    <a href="logout.jsp"> Выход </a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
    <div id="main">
        <div id="sidebar1">
            <h3>
                Меню
            </h3>
            <%
                if (request.getSession(true)
                        .getAttribute(SessionKeys.USER_INFO) != null) {
            %>
            <ul class="linkedList">
                <li class="first">
                    <a href="citation.jsp"> Добавить цитату </a>
                </li>
                <li>
                    <a href="posts.jsp"> Лента </a>
                </li>
                <li>
                    <a href="likesposts.jsp">Любимые посты</a>
                </li>
                <li class="last">
                    <a href="popularposts.jsp">Популярное</a>
                </li>
            </ul>
            <% } %>
        </div>

        <div id="sidebar2">
            <p>
                Цитата дня:
            </p>
            <p>
                <%= Validate.getDayCitation().getText()%>
            </p>
        </div>
</body>
</html>
