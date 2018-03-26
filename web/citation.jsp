<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 04.03.2018
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Citation</title>
</head>
<body>
    <form action="/citation" method="post">
        name: <input type="text" name="citation_name" width="30"/>
        text: <input type="text" name="citation_text" width="10"/>
        <input type="submit" value="Add"/>
    </form>
</body>
</html>
