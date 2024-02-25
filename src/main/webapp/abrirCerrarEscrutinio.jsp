<%@ page import="DAO.OperacionesVotaciones" %>
<%@ page import="Modelo.Votaciones" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
    List<Votaciones> votaciones = operacionesVotaciones.obtenerVotaciones();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Abrir / cerrar escrutinio</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <div class="container">
        <h1>Abrir / cerrar escrutinio</h1>
        <form action="sv_abrirCerrarEscrutinio" method="post">
            <p>Selecciona unas votaciones para abrir o cerrar el escrutinio:</p>
            <select name="idVotaciones" required>
                <option value="" selected disabled>ID de circunscripción, fecha de inicio, fecha de fin, (¿abiertas?)</option>
                <% for (Votaciones votacion : votaciones) { %>
                <option value="<%= votacion.getId() %>"><%= votacion.getCircunscripcion() %>, <%= votacion.getFechaInicio() %>, <%= votacion.getFechaFin() %>, (<%= votacion.isAbiertas() %>)</option>
                <% } %>
            </select>
            <input type="submit" value="Abrir / cerrar">
        </form>
        <a href="menu.jsp"><button>Volver al menú</button></a>
    </div>
</body>
</html>
