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
<form>
    <label>
        <input type="search" id="search" placeholder="Pesquisar por nome do animal" style="width: 40%" />
    </label>
</form>
<body>
    <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>Foto</td>
                <td>Nome</td>
                <td>CPF</td>
                <td>Página para adotar animais</td>
                <td>Perfil</td>
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
                <td><a href="/owners/${owner.id()}">Perfil</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <a href="/owners/new">Cadastrar nova pessoa tutora</a>

</body>
<script>
    document.querySelector('#search').addEventListener('keyup', (event) => {
        const search = event.target.value;
        document.querySelectorAll('tbody tr').forEach(row => {
            if (row.innerText.toLowerCase().includes(search.toLowerCase())) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    })
</script>
</html>