package Model;

public class Asesor {

    private int cedula;
    private String nombre;
    private int telefono;
    private String fechaNacimiento;
    //private java.sql.Date fechaNacimiento;
    private String genero;
    private String cliente;
    private String sede;
    private int edad;
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asesor() {

    }

    public Asesor(int cedula) {
        this.cedula = cedula;
    }

    public Asesor(int id,int cedula, String nombre, int telefono, String fechaNacimiento, String genero, String cliente, String sede, int edad) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
        this.edad = edad;
        
    }
    public Asesor(int cedula, String nombre, int telefono, String fechaNacimiento, String genero, String cliente, String sede, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
        this.edad = edad;
    }

    public Asesor(int cedula, String nombre, int telefono,String  fechaNacimiento, String genero, String cliente, String sede) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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
    
    @Override
    public String toString() {
        return "Clase Asesor:\n Cédula: " + this.cedula + ", Nombre completo " + this.nombre + ", teléfono: " + this.telefono
                + ", Fecha de Nacimiento " + this.fechaNacimiento + ", edad " + this.edad
                + ", género " + this.genero + " , Cliente al cual trabaja " + this.cliente + " en la sede " + this.sede;
    }

}
