<%@ page import="webapp.dbutils.Validate" %>
<%@ page import="webapp.entities.UsersEntity" %>
<%@ page import="webapp.dbutils.SessionKeys" %><%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 31.03.2018
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
    <%request.getSession(true)
                .setAttribute(SessionKeys.USER_INFO, null);%>
    <jsp:forward page="index.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
</body>
</html>
