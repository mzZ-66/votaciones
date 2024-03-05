package Controlador;

import Modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_cerrarSesion", value = "/sv_cerrarSesion")
public class sv_cerrarSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        // obtengo las dos cookies
        Cookie cookies[] = request.getCookies();
        String nombreUsuarioValor = "";
        String localidadUsuarioValor = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("nombreUsuario")) {
                nombreUsuarioValor = cookie.getValue();
                cookie.setMaxAge(0);
            }
            if (cookie.getName().equals("localidadUsuario")) {
                localidadUsuarioValor = cookie.getValue();
                cookie.setMaxAge(0);
            }
        }
        if (!nombreUsuarioValor.isEmpty()) {
            request.getSession().removeAttribute("usuario");
            response.sendRedirect("genericSuccess.jsp" + "?mensaje=Hasta luego, " + nombreUsuarioValor + ", de " + localidadUsuarioValor + ". Has cerrado sesión.");
        }
    }
}