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

    <form>

        <label>
            <input type="text" name="name" required />
        </label>
        <label>
            <input type="number" name="monthlyCost" required min="10" />
        </label>
        <label>
            <input type="date" name="birthday" required />
        </label>
        <label>
            <select name="animalKind">
                <option value=""></option>
            </select>
        </label>
        //Select animalKind
        //Select animalSize
        <label>
            <input type="url" name="photoUrl" required />
        </label>
    </form>
</body>
</html>