
package Model;

import java.sql.Date;

public class Asesor {
    
    private int cedula;
    private String nombre;
    private int telefono;
    private Date fechaNacimiento;
    private String genero;
    private String cliente;
    private String sede;
    private int edad;
    
    
    public Asesor(){
        
    }
    
    public Asesor(int cedula){
        this.cedula= cedula;
    }
    
    public Asesor(String nombre,int telefono, Date fechaNacimiento, String genero, String cliente, String sede, int edad){
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
        this.edad = edad;
        
    }

    public Asesor(int cedula, String nombre, int telefono, Date fechaNacimiento, String genero, String cliente, String sede, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
        this.edad = edad;
    }

    public Asesor(int cedula, String nombre, int telefono, Date fechaNacimiento, String genero, String cliente, String sede) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
    }
    
    
    
     public int getCedula(){
        return this.cedula;
    }
     
    public void setCedula(int cedula){
        this.cedula= cedula;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
   
    public String toString(){
        return "Clase Asesor: cedula "+ this.cedula+ " nombre "+ this.nombre +" telefono "+this.telefono
                + " Fecha de Nacimiento "+ this.fechaNacimiento + " edad "+ this.edad +
                " Cliente al cual trabaja "+ this.cliente+ " sede "+ this.sede;
    }
    
}
