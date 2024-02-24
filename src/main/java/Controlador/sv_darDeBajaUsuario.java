package Controlador;

import DAO.OperacionesUsuario;
import Modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_darDeBajaUsuario", value = "/sv_darDeBajaUsuario")
public class sv_darDeBajaUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            operacionesUsuario.darDeBajaUsuario(usuario.getDni());
            request.getSession().removeAttribute("usuario");

            response.sendRedirect("genericSuccess.jsp" + "?mensaje=Te has dado de baja. Tu sesión se ha cerrado.");
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp" + "?mensaje=" + e.getMessage());
        }
    }
}