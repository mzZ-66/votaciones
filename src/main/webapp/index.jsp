<%@ page import="java.util.ArrayList" %>
<%@ page import="DAO.ConexionBD" %>
<%
    ConexionBD conexion = new ConexionBD();
    ArrayList<String> circunscripciones = (ArrayList<String>) request.getAttribute("circunscripciones");
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login de votaciones</title>
    <link rel="stylesheet" type="text/css" href="CSS/styles.css">
</head>
<body>
    <div class="formulario">
        <h1>Registrarse</h1>
        <form action="sv_registro" method="post">
            <input type="text" name="dni" placeholder="DNI" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <input type="text" name="nombreCompleto" placeholder="Nombre y Apellidos" required>
            <div class="date-wrapper">
                <input type="date" name="fechaNac" required>
            </div>
            <input type="text" name="domicilio" placeholder="Domicilio" required>
            <label>¿Qué tipo de usuario eres?<br>
                <label>Votante
                    <input type="radio" name="tipoUsuario" value="Votante" checked>
                </label><br>
                <label>Admin.
                    <input type="radio" name="tipoUsuario" value="Admin">
                </label>
            </label>
            <select name="circunscripcion" required>
                <option value="" selected disabled>Selecciona una opción</option>
<%--                <option value="1">Circunscripción 1</option>--%>
            </select>
            <input type="submit" value="Registrarse">
        </form>
    </div>
    <div class="formulario">
        <h1>Login</h1>
        <form action="login" method="post">
            <input type="text" name="dni" placeholder="DNI" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>