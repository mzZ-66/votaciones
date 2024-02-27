<%@ page import="DAO.OperacionesCircunscripcion" %>
<%@ page import="Modelo.Circunscripcion" %>
<%@ page import="java.util.List" %>
<%
    OperacionesCircunscripcion operacionesCircunscripcion = new OperacionesCircunscripcion();
    List<Circunscripcion> circunscripciones = operacionesCircunscripcion.obtenerCircunscripcion();
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login de votaciones</title>
    <link rel="stylesheet" type="text/css" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <div class="container">
        <h1>Registrarse</h1>
        <form action="sv_registro" method="post">
            <input type="text" name="dni" placeholder="DNI" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <input type="text" name="nombreCompleto" placeholder="Nombre y Apellidos" required>
            <div class="date-wrapper">
                <input type="date" name="fechaNac" required>
            </div>
            <input type="text" name="domicilio" placeholder="Domicilio" required><br>
            <label>¿A qué circunscripción perteneces?<br>
                <select name="circunscripcion" required>
                    <option value="" selected disabled>Localidad, Provincia</option>
                    <% for (Circunscripcion circunscripcion : circunscripciones) { %>
                        <option value="<%= circunscripcion.getId() %>"><%= circunscripcion.getLocalidad() %>, <%= circunscripcion.getProvincia() %></option>
                    <% } %>
                </select>
            </label>
            <input type="submit" value="Registrarse">
        </form>
    </div>
    <div class="container">
        <h1>Login</h1>
        <form action="sv_login" method="post">
            <input type="text" name="dni" placeholder="DNI" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>