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
    <title>Nova adoção</title>
</head>
<body>
<h3>Nova adoção</h3>

<c:if test="${not empty adoptError}">
    <p style="color: red">${adoptError}</p>
</c:if>

<section class="owner-information">
    <img src="${owner.photoUrl()}" width="150px" height="150px" alt="Foto do tutor ${owner.name()}" />
    <h3>Nome: ${owner.name()}</h3>
    <p><strong>CPF: </strong> ${owner.cpf()}</p>
</section>

<h3>Animais disponíveis para adoção</h3>

<c:if test="${empty animalsThatCanBeAdopted}">
    <p>
        No momento não existem animais disponíveis para serem adotados =)
        Mas entre na nossa <a href="#">lista de espera</a>
    </p>
</c:if>
<c:if test="${not empty animalsThatCanBeAdopted}">
    <table>
        <thead>
        <tr>
            <td>Foto</td>
            <td>ID</td>
            <td>Nome</td>
            <td>Porte</td>
            <td>Tipo</td>
            <td>Idade</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${animalsThatCanBeAdopted}" var="animal">
            <tr>
                <td> <img src="${animal.photoUrl}" style="object-fit: contain" width="100px" height="100px" alt="Imagem do animal" /> </td>
                <td>${animal.id}</td>
                <td>${animal.name}</td>
                <td>${animal.size}</td>
                <td>${animal.kind}</td>
                <td>${animal.ageInYears}</td>
                <td>
                    <form action="/adoptions" method="POST">
                        <input type="hidden" name="ownerId" value="${owner.id()}">
                        <input type="hidden" name="animalId" value="${animal.id}">
                        <button type="submit">Adotar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</c:if>

</body>
</html>