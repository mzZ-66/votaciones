<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 24/02/2024
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Modelo.Usuario" %>
<%
    try {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Usuario.TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        System.out.println("Tipo de usuario actual: " + tipoUsuario);
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <% if (tipoUsuario == Usuario.TipoUsuario.Admin) { %>
    <div class="container">
        <h2>Menú de Administrador</h2>
        <form action="listadoCenso.jsp" method="post"> <!-- TODO: Añadir en la tabla si el usuario ha votado o no -->
            <button type="submit">Ver listado del censo</button>
        </form>
        <form action="crearVotaciones.jsp" method="post">
            <button type="submit">Crear votación</button>
        </form>
        <form action="abrirCerrarEscrutinio" method="post">
            <button type="submit">Abrir / cerrar escrutinio</button>
        </form>
        <form action="verResultados" method="post">
            <button type="submit">Ver resultados de votación</button>
        </form>
    </div>
    <% } else if (tipoUsuario == Usuario.TipoUsuario.Votante) { %>
    <div class="container">
        <h2>Menú de Votante</h2>
        <form action="sv_darDeBajaUsuario" method="post"> <!-- TODO: Solo se debe hacer si el escrutinio está cerrado -->
            <button type="submit">Darse de baja</button>
        </form>
        <form action="modificarDatosUsuario.jsp" method="post"> <!-- TODO: Solo se debe hacer si el escrutinio está cerrado -->
            <button type="submit">Modificar datos</button>
        </form>
        <form action="votar" method="post">
            <button type="submit">Votar</button>
        </form>
        <form action="verResultados" method="post">
            <button type="submit">Ver resultados de votación</button>
        </form>
    </div>
    <% } %>
</body>
</html>
<%
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }
%>