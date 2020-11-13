package Controlador;

import Model.Asesor;
import Model.Conexion;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AsesorJDBC {

    public static final String SELECT = "SELECT cedula, nombre, telefono , fechaNacimiento ,edad ,genero, Cliente, sede FROM asesor";
    public static final String INSERT = "INSERT INTO asesor (cedula, nombre,telefono, fechaNacimiento, genero, cliente, sede) values (?,?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE asesor SET cedula=?, nombre=?, telefono=?, fechaNacimiento=?, genero=? , cliente=?,sede=? WHERE id=?";
    public static final String DELETE = "DELETE FROM asesor WHERE cedula=?";
    public static final String PROC_ALM = "{call practicajavamysql.AsignarEdad()}";

    DateFormat objDF = new SimpleDateFormat("yyyy-MM-dd");

    public List<Asesor> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Asesor> asesores = new ArrayList<Asesor>();
        Asesor asesor;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                int telefono = rs.getInt("telefono");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String genero = rs.getString("genero");
                String cliente = rs.getString("cliente");
                String sede = rs.getString("sede");
                int edad = rs.getInt("edad");

                asesor = new Asesor(cedula, nombre, telefono, fechaNacimiento, genero, cliente, sede, edad);
                asesores.add(asesor);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asesores;
    }

    public static void insertar(Asesor asesor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        // Date date = asesor.getFechaNacimiento();
//       java.util.Date sqldate = new java.sql.Date(date.compareTo(asesor.getFechaNacimiento()));

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);

            stmt.setInt(1, asesor.getCedula());
            stmt.setString(2, asesor.getNombre());
            stmt.setInt(3, asesor.getTelefono());
            stmt.setString(4, asesor.getFechaNacimiento());
            stmt.setString(5, asesor.getGenero());
            stmt.setString(6, asesor.getCliente());
            stmt.setString(7, asesor.getSede());
            stmt.setInt(8, asesor.getCedula());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

    }

    public static void actualizar(Asesor asesor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        //java.util.Date date = asesor.getFechaNacimiento();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setInt(1, asesor.getCedula());
            stmt.setString(2, asesor.getNombre());
            stmt.setInt(3, asesor.getTelefono());
            stmt.setString(4, asesor.getFechaNacimiento());
            stmt.setString(5, asesor.getGenero());
            stmt.setString(6, asesor.getCliente());
            stmt.setString(7, asesor.getSede());
            stmt.setInt(8, asesor.getId());
            

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    public static void eliminar(Asesor asesor) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);

            stmt.setInt(1, asesor.getCedula());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

    }

    public static void generarEdades() {

        Connection conn = null;
        CallableStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(PROC_ALM);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

    }

}
