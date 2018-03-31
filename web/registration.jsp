<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 03.03.2018
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<div id="content">
    <div id="box1">
    <h1>Добро пожаловать, пройдите регистрацию!</h1>
    <form action="/registration" method="post">
        <label><b>Логин</b></label>
        <input type="text" placeholder="Введите логин" name="loginname" required>
        <label><b>E-mail</b></label>
        <input type="text" placeholder="Введите e-mail" name="email" required>
        <label><b>Пароль</b></label>
        <input type="password" placeholder="Введите пароль" name="password" required>
        <label><b>Пароль</b></label>
        <input type="password" placeholder="Повторите пароль" name="rppassword" required>
        <button type="submit">Регистрация</button>
    </form>
    </div>
</div>
<div id="copyright">
    &copy; Aware, 2018</a>
</div>
</div>
</div>
</body>
</html>
