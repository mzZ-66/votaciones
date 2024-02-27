package Controlador;

import DAO.OperacionesUsuario;
import Modelo.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_registro", value = "/sv_registro")
public class sv_registro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String password = request.getParameter("password");
        String nombreCompleto = request.getParameter("nombreCompleto");
        String fechaNac = request.getParameter("fechaNac");
        String domicilio = request.getParameter("domicilio");
        Usuario.TipoUsuario tipoUsuario = Usuario.TipoUsuario.Votante;
        int circunscripcion = Integer.parseInt(request.getParameter("circunscripcion"));
        boolean activo = true;

        Usuario usuario = new Usuario(dni, password, nombreCompleto, fechaNac, domicilio, tipoUsuario, circunscripcion, activo);
        try {
            OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
            operacionesUsuario.registrarUsuario(usuario);
            response.sendRedirect("genericSuccess.jsp" + "?mensaje=Te has registrado correctamente. Ahora puedes iniciar sesión.");
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp" + "?mensaje=" + e.getMessage());
        }
    }
}