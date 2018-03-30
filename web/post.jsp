<%@ page import="webapp.servlets.PostServlet" %>
<%@ page import="webapp.entities.CommentsEntity" %>
<%@ page import="webapp.dbutils.Validate" %><%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 24.03.2018
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div id="content">
    <form action="/post" method="post">
        <label>
            <p><b><%= PostServlet.citationsEntity.getName() %>
            </b></p>
            <p><%= PostServlet.citationsEntity.getText() %>
            </p>
            <p>Likes = <%= PostServlet.citationsEntity.getLikes() %>        Dislikes
                = <%= PostServlet.citationsEntity.getDislikes() %>
            </p>
        </label>
        <input type="submit" value="Like" name="like"/>
        <input type="submit" value="Dislike" name="dislike"/>
        <label><p><b>Comment</b></p></label>
        <input type="text" name="comm" width="300"/>
        <input type="submit" value="Comment" name="comment"/>
        <label><p><b>Comments:</b></p></label>
        <% for (CommentsEntity commentsEntity : PostServlet.getComments()) { %>
        <label><b><%= Validate.getUserName(commentsEntity.getUserId())%>
        </b></label>
        <label><p><%= commentsEntity.getText()%>
        </p></label>
        <% } %>
    </form>
</div>
<div id="copyright">
    &copy; Aware, 2018</a>
</div>
</div>
</div>
</body>
</html>
