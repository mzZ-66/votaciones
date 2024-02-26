package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class OperacionesUsuario {
    private Connection conexion;

    public OperacionesUsuario() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }

    public void registrarUsuario(Usuario usuario) throws SQLException, Exception {
        LocalDate fechaNac = LocalDate.parse(usuario.getFechaNac());
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNac, fechaActual);
        int edad = periodo.getYears();
        if (edad < 18) {
            throw new Exception("Debes ser mayor de edad para registrarte.");
        }
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

//    public void loginUsuario(String dni, String password) throws SQLException {
//
//    }

    public Usuario loginUsuario(String dni, String password) throws SQLException, Exception {
        String sql = "SELECT * FROM usuario WHERE dni = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new Exception("El DNI del usuario no está registrado.");
                }
                Usuario usuario = new Usuario();
                usuario.setDni(rs.getString("dni"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombreCompleto(rs.getString("nombreCompleto"));
                usuario.setFechaNac(rs.getString("fechaNac"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(rs.getString("tipoUsuario")));
                usuario.setCircunscripcion(rs.getInt("circunscripcion"));
                usuario.setActivo(rs.getBoolean("activo"));

                // comprueba si el usuario está activo
                if (!usuario.isActivo()) {
                    throw new Exception("El usuario no está activo (Dado de baja).");
                }

                // si está activo, comprueba la contraseña
                if (password.equals(usuario.getPassword())) {
                    return usuario;
                } else {
                    throw new Exception("La contraseña introducida es incorrecta.");
                }
            }
        }
    }

    public void darDeBajaUsuario(String dni) throws SQLException, Exception {
        String sql = "UPDATE usuario SET activo = false WHERE dni = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, dni);

        if (ps.executeUpdate() == 0) {
            throw new Exception("El usuario con DNI " + dni + " no está registrado.");
        }
    }

    public void modificarUsuario(Usuario usuarioActualizado, String dni) throws SQLException, Exception {
        String sql = "UPDATE usuario SET password = ?, nombreCompleto = ?, fechaNac = ?, domicilio = ?, circunscripcion = ? WHERE dni = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, usuarioActualizado.getPassword());
        ps.setString(2, usuarioActualizado.getNombreCompleto());
        ps.setString(3, usuarioActualizado.getFechaNac());
        ps.setString(4, usuarioActualizado.getDomicilio());
        ps.setInt(5, usuarioActualizado.getCircunscripcion());
        ps.setString(6, dni);
        if (ps.executeUpdate() == 0) {
            throw new Exception("El usuario con DNI " + dni + " no está registrado.");
        }
    }

    // obtengo todos los usuarios para mostrarlos en la tabla de listadoCenso.jsp
    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setDni(rs.getString("dni"));
            usuario.setPassword(rs.getString("password"));
            usuario.setNombreCompleto(rs.getString("nombreCompleto"));
            usuario.setFechaNac(rs.getString("fechaNac"));
            usuario.setDomicilio(rs.getString("domicilio"));
            usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(rs.getString("tipoUsuario")));
            usuario.setCircunscripcion(rs.getInt("circunscripcion"));
            usuario.setActivo(rs.getBoolean("activo"));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public boolean haVotado(String dni) throws SQLException {
        String sql = "SELECT * FROM voto WHERE votante = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

}
