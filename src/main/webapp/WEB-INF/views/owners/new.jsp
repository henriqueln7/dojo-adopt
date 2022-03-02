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
    <title>Cadastro de Tutores</title>
</head>
<body>
<h3>Cadastro de Tutor</h3>

<form:form modelAttribute="createOwnerForm" method="POST" action="/owners">
    <form:errors  cssStyle="color: red"/>
    <label>
        Nome do tutor
        <form:input type="text" path="name" required="required" />
        <form:errors path="name" cssStyle="color: red"/>
    </label>
    <label>
        Remuneração (R$)
        <form:input type="number" path="remuneration" required="required" />
        <form:errors path="remuneration" cssStyle="color: red"/>
    </label>
    <label>
        CPF
        <input type="text" name="cpf" required />
        <form:errors path="cpf" cssStyle="color: red"/>
    </label>
    <label>
        Data de nascimento
        <form:input type="date" path="birthday" required="required" />
        <form:errors path="birthday" cssStyle="color: red"/>
    </label>
<%--    <label>--%>
<%--        Tipo do animal--%>
<%--        <form:select path="animalKind" items="${animalKinds}" itemLabel="displayName" />--%>
<%--        <form:errors path="animalKind" cssStyle="color: red"/>--%>
<%--    </label>--%>

    <input type="submit" value="Criar novo animal " />
</form:form>
</body>
</html>