<%@ page import="Modelo.Circunscripcion" %>
<%@ page import="DAO.OperacionesCircunscripcion" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 24/02/2024
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    OperacionesCircunscripcion operacionesCircunscripcion = new OperacionesCircunscripcion();
    List<Circunscripcion> circunscripciones = operacionesCircunscripcion.obtenerCircunscripcion();
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear votación</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <div class="container">
        <h1>Crear votación</h1>
        <form action="sv_crearVotaciones" method="post">
            <label>Circunscripción<br>
                <select name="circunscripcion" required>
                    <option value="" selected disabled>Localidad, Provincia</option>
                    <% for (Circunscripcion circunscripcion : circunscripciones) { %>
                    <option value="<%= circunscripcion.getId() %>"><%= circunscripcion.getLocalidad() %>, <%= circunscripcion.getProvincia() %></option>
                    <% } %>
                </select>
            </label>
            <label>Fecha de inicio<br>
                <input type="date" name="fechaInicio" required>
            </label>
            <label>Fecha de fin<br>
                <input type="date" name="fechaFin" required>
            </label>

            <input type="submit" value="Crear">
        </form>
    </div>
</body>
</html>
