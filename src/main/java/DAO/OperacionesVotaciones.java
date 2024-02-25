package DAO;

import Modelo.Votaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Votaciones> obtenerVotaciones() throws SQLException {
        List<Votaciones> votaciones = new ArrayList<>();
        String query = "SELECT * FROM votaciones";
        PreparedStatement consulta = conexion.prepareStatement(query);
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int circunscripcion = rs.getInt("circunscripcion");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            boolean abiertas = rs.getBoolean("abiertas");
            Votaciones votacion = new Votaciones(id, circunscripcion, fechaInicio, fechaFin, abiertas);
            votaciones.add(votacion);
        }
        rs.close();
        consulta.close();
        return votaciones;
    }

    public Votaciones obtenerVotacionPorId(int idVotaciones) throws SQLException {
        String query = "SELECT * FROM votaciones WHERE id = ?";
        PreparedStatement consulta = conexion.prepareStatement(query);
        consulta.setInt(1, idVotaciones);
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            int circunscripcion = rs.getInt("circunscripcion");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            boolean abiertas = rs.getBoolean("abiertas");
            return new Votaciones(id, circunscripcion, fechaInicio, fechaFin, abiertas);
        }
        rs.close();
        consulta.close();
        return null;
    }

    // estos dos métodos se usan al abrir/cerrar el escrutinio
    public void invertirEstadoEscrutinio(Votaciones votacion) throws SQLException {
        String query = "UPDATE votaciones SET abiertas = ? WHERE id = ?";
        try (PreparedStatement consulta = conexion.prepareStatement(query)) {
            consulta.setBoolean(1, !votacion.isAbiertas()); // Invertir el estado
            consulta.setInt(2, votacion.getId());
            consulta.executeUpdate();
        }
    }
    public boolean existeVotacionAbierta() throws SQLException {
        String query = "SELECT * FROM votaciones WHERE abiertas = 1";
        PreparedStatement consulta = conexion.prepareStatement(query);
        ResultSet rs = consulta.executeQuery();
        boolean existe = rs.next();
        rs.close();
        consulta.close();
        return existe;
    }

    // en cambio, este es para cuando se vota
    public int obtenerVotacionActiva() throws SQLException {
        int votaciones = 0;
        String query = "SELECT id FROM votaciones WHERE abiertas = 1";
        PreparedStatement consulta = conexion.prepareStatement(query);
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            votaciones = rs.getInt("id");
        }
        rs.close();
        consulta.close();
        return votaciones;
    }

    public void comprobarCircunscripcionDelVotante(String dni, int idVotaciones) throws SQLException {
        String query = "SELECT * FROM votaciones WHERE id = ? AND circunscripcion = (SELECT circunscripcion FROM usuario WHERE dni = ?)";
        PreparedStatement consulta = conexion.prepareStatement(query);
        consulta.setInt(1, idVotaciones);
        consulta.setString(2, dni);
        ResultSet rs = consulta.executeQuery();
        if (!rs.next()) {
            throw new SQLException("No puedes votar: no perteneces a la circunscripción de la votación.");
        }
    }
}
