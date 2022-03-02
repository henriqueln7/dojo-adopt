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
    <title>Cadastro de Animal</title>
</head>
<body>
    <h3>Cadastro de Animal</h3>

    <form:form modelAttribute="createAnimalForm" method="POST" action="/animals">
        <form:errors  cssStyle="color: red"/>
        <label>
            Nome do animal
            <form:input type="text" path="name" required="required" />
            <form:errors path="name" cssStyle="color: red"/>
        </label>
        <label>
            Custo mensal (R$)
            <form:input type="number" path="monthlyCost" required="required" min="10" />
            <form:errors path="monthlyCost" cssStyle="color: red"/>
        </label>
        <label>
            Data de nascimento
            <form:input type="date" path="birthday" required="required" />
            <form:errors path="birthday" cssStyle="color: red"/>
        </label>
        <label>
            Tipo do animal
            <form:select path="animalKind" items="${animalKinds}" itemLabel="displayName" />
            <form:errors path="animalKind" cssStyle="color: red"/>
        </label>
        <label>
            Tamanho do animal
            <form:select path="animalSize" items="${animalSizes}" itemLabel="displayName" />
            <form:errors path="animalSize" cssStyle="color: red"/>
        </label>
        <label>
            Foto do animal (URL)
            <input type="url" name="photoUrl" required />
            <form:errors path="photoUrl" cssStyle="color: red"/>
        </label>
        <input type="submit" value="Criar novo animal " />
    </form:form>
</body>
</html>