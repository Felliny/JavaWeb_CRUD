<%--
  Created by IntelliJ IDEA.
  User: T-GAMER
  Date: 25/02/2024
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/styles.css">
<html>
<head>
    <title>Professor</title>
</head>
<body>
    <div>
        <jsp:include page="menu.jsp" />
    </div>
    <br />
    <div align="center" class="container">
        <form action="professor" method="post">
            <p class="tittle">
                <b>Professor</b>
            </p>
            <table>
                <tr>
                    <td colspan="3">
                        <input class="input_data_id" type="number" min="0" step="1" id="codigo" name="codigo"
                            placeholder="Codigo" value="<c:out value="${professor.codigo}"/>">
                    </td>
                    <td>
                        <input type="submit" id="botao" name="botao" value="Buscar">
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input class="input_data" type="text" id="nome" name="nome" placeholder="Nome"
                               value="<c:out value="${professor.nome}"/>">
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input class="input_data" type="text" id="titulacao" name="titulacao" placeholder="Titulação"
                               value="<c:out value="${professor.titulacao}"/>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" id="botao" name="botao" value="Cadastrar">
                    </td>
                    <td>
                        <input type="submit" id="botao" name="botao" value="Alterar">
                    </td>
                    <td>
                        <input type="submit" id="botao" name="botao" value="Excluir">
                    </td>
                    <td>
                        <input type="submit" id="botao" name="botao" value="Listar">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <br />
    <div align="center">
        <c:if test="${not empty erro}">
            <h2><b><c:out value="${erro}"/></b></h2>
        </c:if>
    </div>
    <div align="center">
        <c:if test="${not empty saida}">
            <h3><b><c:out value="${saida}"/></b></h3>
        </c:if>
    </div>
    <br />
    <div align="center">
        <c:if test="${not empty professores}">
            <table class="table_round">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Titulação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${professores}">
                        <tr>
                            <td><c:out value="${p.codigo}" /></td>
                            <td><c:out value="${p.nome}" /></td>
                            <td><c:out value="${p.titulacao}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>
