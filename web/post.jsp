<%@ page import="webapp.servlets.PostServlet" %>
<%@ page import="webapp.entities.CommentsEntity" %><%--
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
</head>
<body>
<form action="/post" method="post">
    <tr>
        <td><%= PostServlet.citationsEntity.getName() %></td>
        <td><%= PostServlet.citationsEntity.getText() %></td>
        <td>Likes count = <%= PostServlet.citationsEntity.getLikes() %></td>
        <td>Dislikes count = <%= PostServlet.citationsEntity.getDislikes() %></td>
        <td><input type="submit" value="Like" name="like"/></td>
        <td><input type="submit" value="Dislike" name="dislike"/></td>
        Comment: <input type="text" name="comm" width="300"/>
        <td><input type="submit" value="Comment" name="comment"/></td>
        <% for(CommentsEntity commentsEntity : PostServlet.getComments()){ %>
        <td><%= commentsEntity.getText()%></td>
        <% } %>
    </tr>

</form>
</body>
</html>
