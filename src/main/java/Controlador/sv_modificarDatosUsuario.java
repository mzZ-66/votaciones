package Controlador;

import DAO.OperacionesUsuario;
import DAO.OperacionesVotaciones;
import Modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_modificarDatosUsuario", value = "/sv_modificarDatosUsuario")
public class sv_modificarDatosUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        String password = request.getParameter("password");
        String nombreCompleto = request.getParameter("nombreCompleto");
        String fechaNac = request.getParameter("fechaNac");
        String domicilio = request.getParameter("domicilio");
        int circunscripcion = Integer.parseInt(request.getParameter("circunscripcion"));

        Usuario usuarioActualizado = new Usuario(usuario.getDni(), password, nombreCompleto, fechaNac, domicilio, usuario.getTipoUsuario(), circunscripcion, usuario.isActivo());
        try {
            OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
            if (!operacionesVotaciones.existeVotacionAbierta()) {
                OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
                operacionesUsuario.modificarUsuario(usuarioActualizado, usuario.getDni());
                request.getSession().removeAttribute("usuario"); // le cierro la sesión para que la inicie otra vez y los datos de sesión sean correctos.
                response.sendRedirect("genericSuccess.jsp" + "?mensaje=Datos modificados correctamente. Vuelve a iniciar sesión.");
            } else {
                response.sendRedirect("genericError.jsp" + "?mensaje=Hay unas votaciones en curso. No puedes modificar tus datos hasta que acaben.");
            }
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp" + "?mensaje=" + e.getMessage());
        }
    }
}