<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ tagLib uri="jakarta.tags.core" prefix="c"%>

<head>
    <title> Lista de patrimonio</title>
</head>
<body>
<h2> CONTROLE DE PATRIMONIO </h2>
<a href="/patrimonio/novo">Cadastro novo</a>
<table>


    <thead>
    <th> ID </th>
    <th> NR PATRIMONIO </th>
    <th> DESCRICAO </th>
    <th> LOCAL </th>
    <th> AÇÕES </th>

    </thead>

    <tbody>
    <c:forEach var="item" items="${listapatrimonios}"   >
    <tr>
        <td> ${item.id} </td>
        <td> ${item.nrpatrimonio} </td>
        <td> ${item.descricao} </td>
        <td> ${item.local} </td>

        <td>
            <a href="/patrimonios/editar/${item.id}"> Editar </a>
            <a href="/patrimonios/excluir/${item.id}" onclick="return confirm('Deseja excluir este patrimônio ? ')"> Excluir </a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
