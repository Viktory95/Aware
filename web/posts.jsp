<%@ page import="webapp.entities.CitationsEntity" %>
<%@ page import="webapp.servlets.PostsServlet" %><%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 17.03.2018
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
</head>
<body>
    <form action="/posts" method="post">
        <%
            for (CitationsEntity citationsEntity : PostsServlet.getCitations()) {
        %>
        <tr>
            <td><%= citationsEntity.getName() %></td>
            <td><%= citationsEntity.getText() %></td>
            <td><input type="submit" value="Info" name=<%= citationsEntity.getCitationId() %>/></td>
        </tr>
        <%
            }
        %>
    </form>
</body>
</html>
