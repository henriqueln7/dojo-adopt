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
    <title>Relatórios</title>
</head>
<body>

<h1>Relatórios</h1>
<main style="display: flex; flex-direction: column">
    <a href="/reports/namesByKind">Nome dos animais por tipo</a>
    <a href="/reports/monthlyCostsByKind">Custo médio mensal dos animais por tipo</a>

</main>

</body>
</html>