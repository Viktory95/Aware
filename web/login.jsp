<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 03.03.2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<div id="content">
    <div id="box1">
        <h1>Добро пожаловать, произведите вход!</h1>
        <form action="/login" method="post">
            <label><b>Логин</b></label>
            <input type="text" placeholder="Введите логин" name="loginname" required>

            <label><b>Пароль</b></label>
            <input type="password" placeholder="Введите пароль" name="password" required>

            <button type="submit">Вход</button>
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
