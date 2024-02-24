package DAO;

import Modelo.Circunscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCircunscripcion {
    private Connection conexion;

    public OperacionesCircunscripcion() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }

    public List<Circunscripcion> obtenerCircunscripcion() throws SQLException {
        List<Circunscripcion> circunscripciones = new ArrayList<>();
        String query = "SELECT * FROM circunscripcion";
        PreparedStatement consulta = conexion.prepareStatement(query);
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String localidad = rs.getString("localidad");
            String provincia = rs.getString("provincia");
            Circunscripcion circunscripcion = new Circunscripcion(id, localidad, provincia);
            circunscripciones.add(circunscripcion);
        }
        rs.close();
        consulta.close();
        return circunscripciones;
    }
}
