
package Model;

import java.sql.Connection;
import java.sql.*;

public class Conexion {
    
    private static final String url="jdbc:mysql://localhost/Pract?useSSL=false&serverTimezone=UTC";
    private static final String user="root";
    private static final String password="12345";
    
    public static Connection getConnection() throws SQLException{
        Connection conexion = DriverManager.getConnection(url, user, password);
        return conexion;
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
     public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
     
     public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
         
     
     
    
}
