<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/mvc13">
    <label>Tytuł:
        <input type="text" name="title"/>
    </label>

    <label>Autor:
        <input type="text" name="author"/>
    </label>

    <label>ISBN:
        <input type="text" name="isbn"/>
    </label>

    <input type="submit" value="Zapisz"/>
</form>

</body>
</html>
