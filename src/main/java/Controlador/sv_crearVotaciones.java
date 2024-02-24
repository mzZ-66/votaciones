package Controlador;

import DAO.OperacionesVotaciones;
import Modelo.Votaciones;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_crearVotaciones", value = "/sv_crearVotaciones")
public class sv_crearVotaciones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int circunscripcion = Integer.parseInt(request.getParameter("circunscripcion"));
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");

        Votaciones votaciones = new Votaciones(0, circunscripcion, fechaInicio, fechaFin, false);
        try {
            OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
            operacionesVotaciones.crearVotaciones(votaciones);
            response.sendRedirect("genericSuccess.jsp?mensaje=Votaciones creadas correctamente.");
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp?mensaje=" + e.getMessage());
        }
    }
}