<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>Rola = ${empty param.role ? 'Guest' : param.role}</div>
    <div>Rola = <c:out value="${param.role}" default="Guest"/></div>
    <div>Test = ${test}</div>
</body>
</html>
