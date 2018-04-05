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
    <script src="js/jquery.js"></script>
    <script src="js/translate.js"></script>
</head>
<body>
<div id="content">
    <div id="box1">
        <form action="/citation" method="post">
            <label><b>Название</b></label>
            <input type="text" name="citation_name" required>
            <label><b>Текст</b></label>
            <textarea name="citation_text" id="citation_text" onmouseup="mouseUp()"></textarea>
            <input type="submit" value="Добавить"/>
        </form>
    </div>
</div>
<div id="copyright">
    &copy; Aware, 2018</a>
</div>
</div>
</div>
<script type="text/javascript">
    var dict = {
        "Home": {
            ru: "Russian"
        },
        "Download plugin": {
            ru: "Descarregar plugin",
            en: "Download plugin"
        }
    };
    var translator = $('citation_text').translate({lang: "en", t: dict}); //use English
    translator.lang("ru"); //change to Portuguese
    alert(translator.get("Home"));

    function mouseUp() {
        var editor = document.getElementById("citation_text");
        var editorHTML = editor.innerHTML;
        var selectionStart = 0, selectionEnd = 0;
        if (editor.selectionStart) selectionStart = editor.selectionStart;
        if (editor.selectionEnd) selectionEnd = editor.selectionEnd;
        if (selectionStart != selectionEnd) {
            var editorCharArray = editorHTML.split("");
            editorCharArray.splice(selectionEnd, 0, "</b>");
            editorCharArray.splice(selectionStart, 0, "<b>"); //must do End first
            editorHTML = editorCharArray.join("");
            editor.innerHTML = editorHTML;
        }
        //document.getElementById("citation_text").style.color = "green";
    }
</script>
</body>
</html>
