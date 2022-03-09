<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listagem de Tutores</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>Foto</td>
                <td>Nome</td>
                <td>CPF</td>
                <td>Página para adotar animais</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${ownersView}" var="owner">
            <tr>
                <td> <img src="${owner.photoUrl()}" style="object-fit: contain" width="100px" height="100px" alt="Imagem do tutor" /> </td>
                <td>${owner.id()}</td>
                <td>${owner.name()}</td>
                <td>${owner.cpf()}</td>
                <td><a href="/owners/${owner.id()}/adoptions/new">Adote um animal</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <a href="/owners/new">Cadastrar nova pessoa tutora</a>

</body>
</html>