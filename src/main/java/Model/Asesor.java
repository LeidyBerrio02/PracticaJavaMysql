package Model;

public class Asesor {

    //Creacion de clases con atributos
    private String cedula;
    private String nombre;
    private int telefono;
    private String fechaNacimiento;
    //private java.sql.Date fechaNacimiento;
    private String genero;
    private String cliente;
    private String sede;
    private int edad;

    //Sobre carga de constructores (Cada uno es incluido al utilizar la clase Asesor y ser llamado para hacer su proceso en el crud)
    public Asesor() {

    }

    public Asesor(String cedula) {
        this.cedula = cedula;
    }

    public Asesor(String cedula, String nombre, int telefono, String fechaNacimiento, int edad, String genero, String cliente, String sede) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
    }
    
    public Asesor(String cedula, String nombre, int telefono, String fechaNacimiento, String genero, String cliente, String sede, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
        this.edad = edad;
    }

    public Asesor(String cedula, String nombre, int telefono, String fechaNacimiento, String genero, String cliente, String sede) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
    }

        public Asesor(String cedula, String nombre, int telefono, String fechaNacimiento, String genero, String cliente, String sede, String cedA) {
        this.cedula = cedula;
        this.cedula = cedA;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cliente = cliente;
        this.sede = sede;
    }

   
    //Metodos set y get (set enviar , get obtener)
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
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

    //Metodo toString heredado de la clase padre Object (Para mostrar informacion)
    @Override
    public String toString() {
        return "Clase Asesor:\n Cédula: " + this.cedula + ", Nombre completo " + this.nombre + ", teléfono: " + this.telefono
                + ", Fecha de Nacimiento " + this.fechaNacimiento + ", edad " + this.edad
                + ", género " + this.genero + " , Cliente al cual trabaja " + this.cliente + " en la sede " + this.sede;
    }

}
