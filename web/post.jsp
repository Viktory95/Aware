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
    <script src="js/jquery.js"></script>
    <script src="js/translate.js"></script>
    <script src="js/eng_ru.js"></script>
</head>
<body onmousedown="mouseDown()">
<div id="content">
    <form action="/post" method="post">
        <label>
            <p><b><%= PostServlet.citationsEntity.getName() %>
            </b></p>
            <textarea name="citation_text" id="citation_text"
                      onmouseup="mouseUp()"><%= PostServlet.citationsEntity.getText() %></textarea>
            <div id="tooltip"></div>
            <p>Likes - <%= PostServlet.citationsEntity.getLikes() %>
            </p>
            <p>Dislikes - <%= PostServlet.citationsEntity.getDislikes() %>
            </p>
        </label>
        <input type="submit" value="Like" name="like"/>
        <input type="submit" value="Dislike" name="dislike"/>
        <input type="text" name="comm" width="300"/>
        <input type="submit" value="Комментарий" name="comment"/>
        <label><p><b>Комментарии:</b></p></label>
        <% for (CommentsEntity commentsEntity : PostServlet.getComments()) { %>
        <label><b>Пользователь: <%= Validate.getUserName(commentsEntity.getUserId())%>
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
<script type="text/javascript">

    var translator = $('citation_text').translate({lang: "en", t: dict}); //use English
    translator.lang("ru");

    function mouseUp() {
        var editor = document.getElementById("citation_text");
        var selectionStart = 0, selectionEnd = 0;
        if (editor.selectionStart) selectionStart = editor.selectionStart;
        if (editor.selectionEnd) selectionEnd = editor.selectionEnd;
        document.getElementById("tooltip").innerHTML = translator
            .get(document.getElementById("citation_text")
                .innerHTML
                .substring(selectionStart, selectionEnd).trim());
        $("#tooltip").show();
    }

    function mouseDown() {
        $("#tooltip").hide("slow", function () {
        });
    }
</script>
</body>
</html>
