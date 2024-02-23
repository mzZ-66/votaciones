package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection conexion = null;
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/votaciones", "root", "");
        }
        return conexion;
    }
}
