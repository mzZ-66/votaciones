package Controlador;

import DAO.OperacionesUsuario;
import Modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_login", value = "/sv_login")
public class sv_login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String password = request.getParameter("password");

        try {
            OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
            Usuario usuario = operacionesUsuario.loginUsuario(dni, password);
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("menu.jsp");
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp" + "?mensaje=" + e.getMessage());
        }
    }
}