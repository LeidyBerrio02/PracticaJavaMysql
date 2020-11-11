
package Controlador;

import Model.Asesor;
import Model.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AsesorJDBC {
    
    public static final String SELECT="SELECT cedula, nombre, telefono , fechaNacimiento ,edad ,genero, Cliente, sede FROM asesor";
   public static final String INSERT="INSERT INTO asesor (cedula, nombre,telefono, fechaNacimiento, genero, cliente, sede) values (?,?,?,?,?,?,?)";
   public static final String UPDATE="UPDATE asesor SET cedula=?, nombre=?, telefono=?, fechaNacimiento=?, genero=? , cliente=?,sede=? WHERE cedula=?";
   public static final String DELETE="DELETE FROM asesor WHERE cedula=?";
   
   
   public List<Asesor> select(){
       
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs = null;
       List<Asesor> asesores = new ArrayList<Asesor>();
       Asesor asesor;
       
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                int telefono = rs.getInt("telefono");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String genero = rs.getString("genero");
                String cliente = rs.getString("cliente");
                String sede = rs.getString("sede");
                int edad= rs.getInt("edad");
                
                asesor = new Asesor(cedula,nombre,telefono,fechaNacimiento,genero,cliente,sede,edad);
                asesores.add(asesor);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
       
       
       
        return asesores;
   }   
   
   
   public static void insertar (Asesor asesor){
       
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs=null;
      // Date date = asesor.getFechaNacimiento();
//       java.util.Date sqldate = new java.sql.Date(date.compareTo(asesor.getFechaNacimiento()));
       
       
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            
            
            stmt.setInt(1, asesor.getCedula());
            stmt.setString(2, asesor.getNombre());
            stmt.setInt(3, asesor.getTelefono());
            stmt.setDate(4, asesor.getFechaNacimiento());
            stmt.setString(5, asesor.getGenero());
            stmt.setString(6, asesor.getCliente());
            stmt.setString(7 ,asesor.getSede());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
       
   }
   
   
   public void actualizar (Asesor asesor){
       
       Connection conn = null;
       PreparedStatement stmt = null;
       Date date = asesor.getFechaNacimiento();
       java.util.Date sqldate = new java.sql.Date(date.compareTo(asesor.getFechaNacimiento()));
       
       
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            

            stmt.setString(1, asesor.getNombre());
            stmt.setInt(2, asesor.getTelefono());
            stmt.setDate(3, asesor.getFechaNacimiento());
            stmt.setString(4, asesor.getGenero());
            stmt.setString(5, asesor.getCliente());
            stmt.setString(6 ,asesor.getSede());
            stmt.setDate(7,(Date) sqldate);
            stmt.setInt(8, asesor.getCedula());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
   }
    
   public static void eliminar(Asesor asesor){
       
       Connection conn = null;
       PreparedStatement stmt= null;
       
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            
            stmt.setInt(1, asesor.getCedula());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
       
   }
   
    
}
