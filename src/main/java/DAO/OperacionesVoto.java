package DAO;

import Modelo.Partido;
import Modelo.Voto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperacionesVoto {
    private Connection conexion;

    public OperacionesVoto() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }

    public void votar(Voto voto) throws SQLException {
        String sql = "INSERT INTO voto (votante, partido, votaciones, fechaVoto) VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, voto.getVotante());
        sentencia.setInt(2, voto.getPartido());
        sentencia.setInt(3, voto.getVotaciones());
        sentencia.setString(4, voto.getFechaVoto());
        sentencia.executeUpdate();
    }

    public void comprobarVotoPorDni(String dni, int votaciones) throws SQLException, Exception {
        String sql = "SELECT * FROM voto WHERE votante = ? AND votaciones = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dni);
        sentencia.setInt(2, votaciones);
        if (sentencia.executeQuery().next()) {
            throw new Exception("Ya has votado en estas elecciones.");
        }
    }

    public Map<Integer, Integer> obtenerResultadosElecciones(int idVotaciones) throws SQLException {
        Map<Integer, Integer> resultados = new HashMap<>();
        String sql = "SELECT partido, COUNT(*) AS votos FROM voto WHERE votaciones = ? GROUP BY partido";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idVotaciones);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idPartido = rs.getInt("partido");
            int votos = rs.getInt("votos");
            resultados.put(idPartido, votos);
        }

        return resultados;
    }
}
