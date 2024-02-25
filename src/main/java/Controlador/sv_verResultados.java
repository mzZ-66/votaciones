package Controlador;

import DAO.OperacionesPartido;
import DAO.OperacionesVotaciones;
import DAO.OperacionesVoto;
import Modelo.Partido;
import Modelo.Votaciones;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "sv_verResultados", value = "/sv_verResultados")
public class sv_verResultados extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idVotacion = Integer.parseInt(request.getParameter("votaciones"));
        try {
            // obtengo los resultados de la votacion
            OperacionesVoto operacionesVoto = new OperacionesVoto();
            Map<Integer, Integer> resultados = operacionesVoto.obtenerResultadosElecciones(idVotacion);
            request.getSession().setAttribute("resultados", resultados);

            // obtengo los datos de los partidos para mostrar sus nombres en la vista
            OperacionesPartido operacionesPartido = new OperacionesPartido();
            List<Partido> partidos = operacionesPartido.obtenerPartidos();
            request.getSession().setAttribute("partidos", partidos);

            response.sendRedirect("verResultados.jsp");
        } catch (Exception e) {
            response.sendRedirect("genericError.jsp?mensaje=" + e.getMessage());
        }
    }
}