<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 24/02/2024
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Modelo.Usuario" %>
<%@ page import="DAO.OperacionesCircunscripcion" %>
<%@ page import="Modelo.Circunscripcion" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    OperacionesCircunscripcion operacionesCircunscripcion = new OperacionesCircunscripcion();
    List<Circunscripcion> circunscripciones = operacionesCircunscripcion.obtenerCircunscripcion();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar datos</title>
    <link rel="stylesheet" type="text/css" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
<div class="container">
    <h1>Modificar datos</h1>
    <form action="sv_modificarDatosUsuario" method="post">
        <input type="password" name="password" placeholder="Nueva contraseña">
        <input type="text" name="nombreCompleto" placeholder="Nombre y Apellidos">
        <div class="date-wrapper">
            <input type="date" name="fechaNac" value="<%= usuario.getFechaNac() %>">
        </div>
        <input type="text" name="domicilio" placeholder="Domicilio">
        <select name="circunscripcion" required>
            <option value="" selected disabled>Localidad, Provincia</option>
            <% for (Circunscripcion circunscripcion : circunscripciones) { %>
            <option value="<%= circunscripcion.getId() %>"><%= circunscripcion.getLocalidad() %>, <%= circunscripcion.getProvincia() %></option>
            <% } %>
        </select>
        <input type="submit" value="Guardar cambios">
    </form>
    <a href="menu.jsp"><button>Volver al menú</button></a>
</div>
</body>
</html>
