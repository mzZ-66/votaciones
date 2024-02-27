package Controlador;

import DAO.OperacionesUsuario;
import DAO.OperacionesVotaciones;
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
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        try {
            OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
            if (!operacionesVotaciones.existeVotacionAbierta()) {
                OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
                operacionesUsuario.darDeBajaUsuario(usuario.getDni());
                request.getSession().removeAttribute("usuario");
                response.sendRedirect("genericSuccess.jsp" + "?mensaje=Te has dado de baja. Tu sesión se ha cerrado.");
            } else {
                response.sendRedirect("genericError.jsp" + "?mensaje=Hay unas votaciones en curso. No puedes darte de baja hasta que acaben.");
            }
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp" + "?mensaje=" + e.getMessage());
        }
    }
}