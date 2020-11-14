package Controlador;

import Model.Asesor;
import Model.Conexion;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AsesorJDBC {

    //Variables las cuales van a almacenar las consultas de sql y seran usadas por ResultSet o PreparedStatement
    public static final String SELECT = "SELECT cedula, nombre, telefono , fechaNacimiento ,edad ,genero, Cliente, sede FROM asesor ORDER BY nombre asc";
    public static final String INSERT = "INSERT INTO asesor (cedula, nombre,telefono, fechaNacimiento, genero, cliente, sede) values (?,?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE asesor SET cedula=?, nombre=?, telefono=?, fechaNacimiento=?, genero=? , cliente=?,sede=? WHERE cedula=?";
    public static final String DELETE = "DELETE FROM asesor WHERE cedula=?";
    public static final String PROC_ALM = "{call practicajavamysql.AsignarEdad()}";

    //DateFormat objDF = new SimpleDateFormat("yyyy-MM-dd");
    //Metodo tipo list de la clase asesor la cual nos traera cada valor de cada atributo que se tenga en la clase y base de datos
    public List<Asesor> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Asesor> asesores = new ArrayList<Asesor>();
        Asesor asesor;

        // try catch en caso de que ocurra una excepcion
        try {
            //obteniendo conexion
            conn = Conexion.getConnection();
            //preparando sentencia sql para ser ejecutada
            stmt = conn.prepareStatement(SELECT);
            //se ejecuta sentencia select 
            rs = stmt.executeQuery();

            //mientras el resultado de la sentencia tenga un siguiente valor para mostrar se va a ejecutar el bloque de codigo
            while (rs.next()) {

                //se envian los pareametros que se quieren obtener por medio del get
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                int telefono = rs.getInt("telefono");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String genero = rs.getString("genero");
                String cliente = rs.getString("cliente");
                String sede = rs.getString("sede");
                int edad = rs.getInt("edad");

                // Se inicializa objeto de la clase asesor para añadirlo a la lista de asesores y asi poder ser mostrado
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

        // try catch en caso de que ocurra una excepcion
        try {
            //obteniendo conexion
            conn = Conexion.getConnection();
            //preparando sentencia sql para ser ejecutada
            stmt = conn.prepareStatement(INSERT);

            //se envian los parametros obteniedos a la posicion establecida
            stmt.setString(1, asesor.getCedula());
            stmt.setString(2, asesor.getNombre());
            stmt.setInt(3, asesor.getTelefono());
            stmt.setString(4, asesor.getFechaNacimiento());
            stmt.setString(5, asesor.getGenero());
            stmt.setString(6, asesor.getCliente());
            stmt.setString(7, asesor.getSede());

            // se ejecuta sentencia insert
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
            //obteniendo conexion
            conn = Conexion.getConnection();
            //preparando sentencia sql para ser ejecutada
            stmt = conn.prepareStatement(UPDATE);

            //se envian los parametros obteniedos a la posicion establecida de acuerdo a la condicion
            /*se envian dos cedulas, dado que la base de datos no cuenta con id y se debe enviar 
            la cedula nueva la cual esta siendo actualizada y la antigua para poder que la conficion WHERE se cumpla*/
            stmt.setString(1, asesor.getCedula());
            stmt.setString(2, asesor.getNombre());
            stmt.setInt(3, asesor.getTelefono());
            stmt.setString(4, asesor.getFechaNacimiento());
            stmt.setString(5, asesor.getGenero());
            stmt.setString(6, asesor.getCliente());
            stmt.setString(7, asesor.getSede());
            stmt.setString(8, asesor.getCedula());

            // se ejecuta sentencia update
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
            //Obteniendo conexion
            conn = Conexion.getConnection();
            //Preparando sentencia sql para ser ejecutada
            stmt = conn.prepareStatement(DELETE);

            //Se envia la cedula para que se cumpla la condicion WHERE 
            stmt.setString(1, asesor.getCedula());

            //Se ejecuta sentencia delete
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
            //Se obtiene conexion
            conn = Conexion.getConnection();
            //Se prepara la llamada al procedimiento almacenado de la base de datos
            stmt = conn.prepareCall(PROC_ALM);

            //Se ejecuta el procedimiento almacenado el cual asigna las edades de los asesores dependiendo de su fecha de naciemiento
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

    }

}
