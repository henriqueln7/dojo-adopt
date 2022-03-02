<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listagem de Animais</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>Foto</td>
                <td>ID</td>
                <td>Nome</td>
                <td>Porte</td>
                <td>Tipo</td>
                <td>Idade</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${animalsView}" var="animal">
            <tr>
                <td> <img src="${animal.photoUrl}" style="object-fit: contain" width="100px" height="100px" alt="Imagem do animal" /> </td>
                <td>${animal.id}</td>
                <td>${animal.name}</td>
                <td>${animal.size}</td>
                <td>${animal.kind}</td>
                <td>${animal.ageInYears}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <a href="/animals/new">Cadastrar novo animal</a>

</body>
</html>