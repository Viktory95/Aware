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
</head>
<body>
    <h1>Welcome, please registration!</h1>
    <form action="/registration" method="post">
        login-name: <input type="text" name="loginname" width="30"/>
        e-mail: <input type="text" name="email" width="30">
        password: <input type="password" name="password" width="20"/>
        replace password: <input type="password" name="rppassword" width="20"/>
        <input type="submit" value="Registration"/>
    </form>
</body>
</html>
