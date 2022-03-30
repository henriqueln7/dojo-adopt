<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Relatório - Nome dos animais por tipo</title>
</head>
<body>

<h1>Relatórios</h1>

<c:forEach items="${namesByKind.keySet()}" var="kind">
    <p>${kind}</p>
    <ul>
        <c:forEach items="${namesByKind.get(kind)}" var="name">
            <li>${name}</li>
        </c:forEach>
    </ul>
</c:forEach>

</body>
</html>