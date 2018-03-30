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
    <jsp:include page="header.jsp"/>
</head>
<body>
<div id="content">
    <form action="/posts" method="post">
        <%
            for (CitationsEntity citationsEntity : PostsServlet.getCitations()) {
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
</div>
</div>
</body>
</html>
