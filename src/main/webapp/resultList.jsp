<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Pozycja</th>
        <th>Tytuł</th>
        <th>Autor</th>
        <th>ISBN</th>
    </tr>
    <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
