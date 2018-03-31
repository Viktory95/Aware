<%@ page import="webapp.servlets.PopularPostsServlet" %>
<%@ page import="webapp.entities.CitationsEntity" %><%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 31.03.2018
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PopularPosts</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<div id="content">
    <form action="/popularposts" method="post">
        <%
            for (CitationsEntity citationsEntity : PopularPostsServlet.getCitations()) {
        %>
        <div id="box2">
            <label>
                <p><b><%= citationsEntity.getName() %>
                </b></p>
                <p><%= citationsEntity.getText() %>
                </p>
            </label>
            <input type="submit" value="Info" name=<%= citationsEntity.getCitationId() %>/>
            <%
                }
            %>
        </div>
    </form>
</div>
<div id="copyright">
    &copy; Aware, 2018</a>
</div>
</body>
</html>
