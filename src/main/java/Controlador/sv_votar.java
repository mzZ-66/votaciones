package Controlador;

import DAO.OperacionesVotaciones;
import DAO.OperacionesVoto;
import Modelo.Usuario;
import Modelo.Voto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "sv_votar", value = "/sv_votar")
public class sv_votar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String votante = usuario.getDni();
        int partido = Integer.parseInt(request.getParameter("partido"));
        String fechaVoto = String.valueOf(LocalDate.now());

        try {
            // obtengo la votación que está activa ahora
            OperacionesVotaciones operacionesVotaciones = new OperacionesVotaciones();
            int votaciones = operacionesVotaciones.obtenerVotacionActiva();

            // compruebo que el usuario tiene la misma circunscripción que la votación
            operacionesVotaciones.comprobarCircunscripcionDelVotante(votante, votaciones);

            // compruebo si ya el usuario ha votado
            OperacionesVoto operacionesVoto = new OperacionesVoto();
            operacionesVoto.comprobarVotoPorDni(votante, votaciones);

            // si no ha votado, entonces se registra
            Voto voto = new Voto(0, votante, partido, votaciones, fechaVoto);
            operacionesVoto.votar(voto);
            response.sendRedirect("genericSuccess.jsp?mensaje=Voto realizado correctamente");
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp?mensaje=" + e.getMessage());
        }

    }
}