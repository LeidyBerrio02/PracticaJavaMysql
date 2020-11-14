package Model;

import java.sql.Connection;
import java.sql.*;

public class Conexion {

    //Atributos para accedeer a la base de datos de mysql workbench
    private static final String url = "jdbc:mysql://localhost/PracticaJavaMysql?useSSL=false&serverTimezone=UTC";//ruta base de datos
    private static final String user = "root";//usuario de base de datos
    private static final String password = "12345";//contreña de base de datos

    //Obteniendo conexion
    public static Connection getConnection() throws SQLException {
        Connection conexion = DriverManager.getConnection(url, user, password);
        return conexion;
    }

    //metodos para cerrar (conn, stmt, rs) los cuales nos ayudan a realizar cada metodo de la implementacion 
    // obteniendo, enviando y ejecutando sentencia sql
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
