<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 24/02/2024
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Éxito</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/121693/vote.svg">
</head>
<body>
    <div class="container">
        <h1>CORRECTO</h1>
        <p>
            <%= request.getParameter("mensaje") %>
        </p>
        <a href="menu.jsp"><button>Volver</button></a>
    </div>
</body>
</html>
