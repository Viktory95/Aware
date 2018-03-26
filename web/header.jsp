<%@ page import="webapp.dbutils.Validate" %><%--
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
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="outer">
    <div id="header">
        <div id="logo">
            <h1>
                <a href="#">Aware</a>
            </h1>
        </div>
        <div id="nav">
            <ul>
                <%
                    if(Validate.usersEntity == null){
                %>
                <li class="first">
                    <a href="login.jsp"> Login </a>
                </li>
                <li>
                    <a href="registration.jsp"> Registration </a>
                </li>
                <li>
                    <a href="#">About Us</a>
                </li>
                <li class="last">
                    <a href="#">Contact Us</a>
                </li>
                <%
                }else {
                %>
                <li class="first">
                    <a href="#">About Us</a>
                </li>
                <li>
                    <a href="#">Contact Us</a>
                </li>
                <li class="last">
                    <a href="logout.jsp"> Logout </a>
                </li>
                <% } %>
            </ul>
            <br class="clear" />
        </div>
    </div>
    <div id="main">
        <div id="sidebar1">
            <h3>
                Меню
            </h3>
            <p>
                Цитата дня:
            </p>
            <ul class="linkedList">
                <%
                    if(Validate.usersEntity != null){
                %>
                <li class="first">
                    <a href="citation.jsp"> Добавить цитату </a>
                </li>
                <li>
                    <a href="posts.jsp"> Лента </a>
                </li>
                <li>
                    <a href="#">Любимые посты</a>
                </li>
                <li class="last">
                    <a href="#">Популярное</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
    <div id="copyright">
        &copy; Aware, 2018</a>
    </div>
</body>
</html>
