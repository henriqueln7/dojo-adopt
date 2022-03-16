<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Perfil do tutor - ${ownerProfile.name()}</title>
</head>
<body>

<c:if test="${adoptSuccess}">
    <p style="color: green">${adoptSuccess}</p>
</c:if>

<img src="${ownerProfile.photoUrl()}" width="200px" height="200px" alt="Foto de perfil do tutor ${ownerProfile.name()}" />
<h1>Nome: ${ownerProfile.name()}</h1>

<p>CPF: </p>
<p>Remuneração (R$): </p>
<p>Total Gasto (R$): </p>

</body>
</html>