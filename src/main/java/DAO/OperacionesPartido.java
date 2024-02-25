package DAO;

import Modelo.Partido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesPartido {
    private Connection conexion;

    public OperacionesPartido() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }

    public List<Partido> obtenerPartidos() throws SQLException {
        List<Partido> partidos = new ArrayList<>();
        String query = "SELECT * FROM partido";
        PreparedStatement consulta = conexion.prepareStatement(query);
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String siglas = rs.getString("siglas");
            String nombreCompleto = rs.getString("nombreCompleto");
            Partido partido = new Partido(id, siglas, nombreCompleto);
            partidos.add(partido);
        }
        rs.close();
        consulta.close();
        return partidos;
    }
}
