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
    <jsp:include page="header.jsp"/>
</head>
<body>
<div id="content">
    <div id="box1">
        <form action="/citation" method="post">
            <label><b>Название</b></label>
            <input type="text" name="citation_name" required>
            <label><b>Текст</b></label>
            <input type="text" name="citation_text" required>
            <input type="submit" value="Добавить"/>
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
