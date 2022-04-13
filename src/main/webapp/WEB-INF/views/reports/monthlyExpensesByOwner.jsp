<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Relatório - Gasto por dono</title>
</head>
<body>

<h1>Gasto dos donos</h1>

<table>
    <thead>
    <tr>
        <th>Nome do dono</th>
        <th>Gasto mensal</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${monthlyExpensesByOwner}" var="expense">
        <tr>
            <td>${expense.ownerName}</td>
            <td><fmt:formatNumber value="${expense.monthlyTotalExpenses}" maxFractionDigits="2" minFractionDigits="2" /> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>