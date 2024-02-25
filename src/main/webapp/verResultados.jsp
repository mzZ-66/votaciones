<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Modelo.Partido" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%
    List<Partido> partidos = (List<Partido>) request.getSession().getAttribute("partidos");
    Map<Integer, Integer> resultados = (Map<Integer, Integer>) request.getSession().getAttribute("resultados");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados de las elecciones</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
<div class="container">
    <h1>Resultados de las elecciones</h1>
    <table>
        <tr>
            <th>Siglas</th>
            <th>Nombre Completo</th>
            <th>Votos</th>
        </tr>
        <% for (Partido partido : partidos) { %>
        <tr>
            <td><%= partido.getSiglas() %></td>
            <td><%= partido.getNombreCompleto() %></td>
            <td><%= resultados.getOrDefault(partido.getId(), 0) %></td>
        </tr>
        <% } %>
    </table>
    <a href="menu.jsp"><button>Volver</button></a>
</div>
</body>
</html>
