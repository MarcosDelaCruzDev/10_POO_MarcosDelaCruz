package vallegrande.edu.pe.proyecto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3307/sistema_usuarios";
    private static final String USER = "root";
    private static final String PASSWORD = "123456"; // <-- cambia por tu contraseña de MySQL

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}