<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 24/02/2024
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Modelo.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.OperacionesUsuario" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="DAO.OperacionesCircunscripcion" %>
<%@ page import="Modelo.Circunscripcion" %>
<%
    List<Usuario> usuarios = null;
    List<Circunscripcion> circunscripciones = null;
    try {
        OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
        usuarios = operacionesUsuario.obtenerUsuarios();

        OperacionesCircunscripcion operacionesCircunscripcion = new OperacionesCircunscripcion();
        circunscripciones = operacionesCircunscripcion.obtenerCircunscripcion();
    } catch (SQLException e) {
        response.sendRedirect("genericError.jsp?mensaje=" + e.getMessage());
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado del censo</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
<div class="container">
    <h1>Listado del Censo</h1>
    <table>
        <tr>
            <th>DNI</th>
            <th>Nombre Completo</th>
            <th>Fecha de Nacimiento</th>
            <th>Domicilio</th>
            <th>Tipo de Usuario</th>
            <th>Circunscripción</th>
            <th>¿Activo?</th>
            <th>¿Ha votado?</th>
        </tr>
        <% for (Usuario usuario : usuarios) {
            OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
            boolean haVotado = operacionesUsuario.haVotado(usuario.getDni());
        %>
        <tr>
            <td><%= usuario.getDni() %></td>
            <td><%= usuario.getNombreCompleto() %></td>
            <td><%= usuario.getFechaNac() %></td>
            <td><%= usuario.getDomicilio() %></td>
            <td><%= usuario.getTipoUsuario() %></td>
            <td><%
                String nombreCircunscripcion = null;
                for (Circunscripcion circunscripcion : circunscripciones) {
                    if (circunscripcion.getId() == usuario.getCircunscripcion()) {
                        nombreCircunscripcion = circunscripcion.getLocalidad();
                    }
                }
            %>
            <%= nombreCircunscripcion %></td>
            <td><%= usuario.isActivo() %></td>
            <td><%= haVotado %></td>
        </tr>
        <% } %>
    </table>
    <form action="menu.jsp">
        <input type="submit" value="Volver">
    </form>
</div>
</body>
</html>
