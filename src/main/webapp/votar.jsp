<%@ page import="DAO.OperacionesPartido" %>
<%@ page import="Modelo.Partido" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.OperacionesVotaciones" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try {
        OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
        if (!operacionesVotaciones.existeVotacionAbierta()) {
            response.sendRedirect("genericError.jsp" + "?mensaje=No hay ningunas votaciones en curso.");
        }
    } catch (Exception e) {
        response.sendRedirect("genericError.jsp?mensaje" + e.getMessage());
    }
    OperacionesPartido operacionesPartido = new OperacionesPartido();
    List<Partido> partidos = operacionesPartido.obtenerPartidos();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Votar</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <div class="container">
        <h1>Votar</h1>
        <form action="sv_votar" method="post">
            <p>Selecciona tu voto:</p>
            <select name="partido" required>
                <option value="" selected disabled>Siglas, nombre completo</option>
                <% for (Partido partido : partidos) { %>
                <option value="<%= partido.getId() %>"><%= partido.getSiglas() %>, <%= partido.getNombreCompleto() %></option>
                <% } %>
            </select>
            <input type="submit" value="Votar">
        </form>
        <a href="menu.jsp"><button>Volver al menú</button></a>
    </div>
</body>
</html>
