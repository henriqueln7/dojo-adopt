<jsp:useBean id="ownerProfile" scope="request" type="br.com.alura.dojoadopt.owner.OwnerProfileView"/>
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

<p><strong>CPF:</strong> ${ownerProfile.cpf()} </p>
<p><strong>Remuneração (R$)</strong>: ${ownerProfile.remuneration()} </p>
<p><strong>Total Gasto (R$)</strong>: ${ownerProfile.monthlyExpenses()}</p>

<h3>Animais adotados</h3>
<hr />

<section style="display: flex; flex-direction: row; gap: 2rem">
<c:forEach items="${ownerProfile.adoptedAnimals()}" var="adoptedAnimal">
    <div style="display: flex; flex-direction: column; align-items: center">
    <img src="${adoptedAnimal.photoUrl()}" alt="Foto do animal ${adoptedAnimal.name()}" height="200px" width="200px"/>
    <p style="font-weight: 700">${adoptedAnimal.name()}</p>
    </div>
</c:forEach>
</section>

</body>
</html>