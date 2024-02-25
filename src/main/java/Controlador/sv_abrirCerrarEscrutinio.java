package Controlador;

import DAO.OperacionesVotaciones;
import Modelo.Votaciones;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "sv_abrirCerrarEscrutinio", value = "/sv_abrirCerrarEscrutinio")
public class sv_abrirCerrarEscrutinio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idVotaciones = Integer.parseInt(request.getParameter("idVotaciones"));

        try {
            OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
            Votaciones votacion = operacionesVotaciones.obtenerVotacionPorId(idVotaciones);

            if (votacion.isAbiertas()) { // si las votaciones están abiertas, se cierran
                operacionesVotaciones.invertirEstadoEscrutinio(votacion);
                response.sendRedirect("genericSuccess.jsp?mensaje=Se ha cerrado el escrutinio.");
            } else { // si las votaciones están cerradas, se comprueba si hay otras abiertas
                if (operacionesVotaciones.existeVotacionAbierta()) { // si ya hay una votación abierta, se muestra un mensaje de error
                    response.sendRedirect("genericError.jsp?mensaje=No puede haber más de unas votaciones abiertas a la vez.");
                } else { // si no hay votaciones abiertas, se abren las seleccionadas
                    operacionesVotaciones.invertirEstadoEscrutinio(votacion);
                    response.sendRedirect("genericSuccess.jsp?mensaje=Se ha abierto el escrutinio.");
                }
            }
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp?mensaje=" + e.getMessage());
        }
    }
}