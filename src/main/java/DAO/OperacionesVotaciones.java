package DAO;

import Modelo.Votaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacionesVotaciones {
    private Connection conexion;

    public OperacionesVotaciones() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }

    public void crearVotaciones(Votaciones votaciones) throws SQLException {
        String sql = "INSERT INTO votaciones (circunscripcion, fechaInicio, fechaFin, abiertas) VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, votaciones.getCircunscripcion());
        sentencia.setString(2, votaciones.getFechaInicio());
        sentencia.setString(3, votaciones.getFechaFin());
        sentencia.setBoolean(4, votaciones.isAbiertas());
        sentencia.executeUpdate();
    }
}
