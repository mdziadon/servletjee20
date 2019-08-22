<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <c:forEach begin="0" end="4" varStatus="status">
        <h3>Książka ${status.count}</h3>
        <label>Tytuł:
            <input type="text" name="title"/>
        </label><br><br>

        <label>Autor:
            <input type="text" name="author"/>
        </label><br><br>

        <label>ISBN:
            <input type="text" name="isbn"/>
        </label><br><br>
    </c:forEach>

    <input type="submit" value="Zapisz"/>
</form>
</body>
</html>
