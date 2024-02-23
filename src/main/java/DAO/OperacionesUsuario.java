package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OperacionesUsuario {
    private Connection conexion;

    public OperacionesUsuario() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }

    public void registrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (dni, password, nombreCompleto, fechaNac, domicilio, tipoUsuario, circunscripcion, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, usuario.getDni());
        ps.setString(2, usuario.getPassword());
        ps.setString(3, usuario.getNombreCompleto());
        ps.setString(4, usuario.getFechaNac());
        ps.setString(5, usuario.getDomicilio());
        ps.setString(6, usuario.getTipoUsuario().toString());
        ps.setInt(7, usuario.getCircunscripcion());
        ps.setBoolean(8, usuario.isActivo());
        ps.executeUpdate();
    }
}
