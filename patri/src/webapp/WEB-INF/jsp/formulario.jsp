<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ tagLib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
<title> Formulario de patrimonio</title>
</head>
<body>

<h2> cadastro / edição de patrimonio </h2>

    <form action="/patrimonios/salvar" method="post">

        <label> NR PATRIMONIO </label>
        <input type="text" id="nrpatrimonio" name="nrpatrimonio" value="${patrimonio.nrpatrimonio}" required>
        <label> DESCRICAO </label>
        <input type="text" id="descricao" name="descricao" value="${patrimonio.descricao}" required>
        <label> LOCAL </label>
        <input type="text" id="local" name="local" value="${patrimonio.local}" required>
        
<button type="submit" > Salvar</button>

<a href="/patrimonios" > Cancelar </a>

    </form>
</body>
</html>