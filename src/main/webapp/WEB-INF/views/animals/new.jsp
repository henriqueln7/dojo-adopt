<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cadastro de Animal</title>
</head>
<body>
    <h3>Cadastro de Animal</h3>

    <form method="POST" action="/animals">
        <label>
            Nome do animal
            <input type="text" name="name" required />
        </label>
        <label>
            Custo mensal (R$)
            <input type="number" name="monthlyCost" required min="10" />
        </label>
        <label>
            Data de nascimento
            <input type="date" name="birthday" required />
        </label>
        <label>
            Tipo do animal
            <select name="animalKind">
                <c:forEach items="${animalKinds}" var="animalKind">
                    <option value="${animalKind}">${animalKind.displayName}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            Tamanho do animal
            <select name="animalSize">
                <c:forEach items="${animalSizes}" var="animalSize">
                    <option value="${animalSize}">${animalSize.displayName}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            Foto do animal (URL)
            <input type="url" name="photoUrl" required />
        </label>
        <input type="submit" value="Criar novo animal " />
    </form>
</body>
</html>