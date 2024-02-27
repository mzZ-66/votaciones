<%@ page import="Modelo.Votaciones" %>
<%@ page import="DAO.OperacionesVotaciones" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
    List<Votaciones> votaciones = operacionesVotaciones.obtenerVotaciones();
    if (votaciones.isEmpty()) {
        response.sendRedirect("genericError.jsp?mensaje=Todavía no han habido ningunas votaciones.");
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seleccionar votaciones a mostrar</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <div class="container">
        <form action="sv_verResultados" method="post">
            <p>Selecciona las votaciones que quieres mostrar: (Solo se muestran las que no están activas)</p>
            <select name="votaciones" required>
                <option value="" selected disabled>Circunscripción, fecha de inicio, fecha de fin</option>
                <%  for (Votaciones votacion : votaciones) {
                        if (!votacion.isAbiertas()) {
                %>
                <option value="<%= votacion.getId() %>"><%= votacion.getCircunscripcion() %>, <%= votacion.getFechaInicio() %>, <%= votacion.getFechaFin() %></option>
                <%      }
                    }
                %>
            </select>

            <input type="submit" value="Ver resultados">
        </form>
        <a href="menu.jsp"><button>Volver al menú</button></a>
    </div>
</body>
</html>
