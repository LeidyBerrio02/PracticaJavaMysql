package Test;

import Controlador.AsesorJDBC;
import Model.Asesor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Excepcion, ParseException {

        Scanner leer = new Scanner(System.in);
        //SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-mm-dd");

        int opcion = 0;
        AsesorJDBC asesorJDBC = new AsesorJDBC();
        List<Asesor> asesores = asesorJDBC.select();

        do {
            System.out.println("\n Menu Asesor Opciones: \n"
                    + "1.Mostrar Asesores. \n"
                    + "2.Crear Asesor(es). \n"
                    + "3.Actualizar Informacion. \n"
                    + "4.Eliminar Asesor. \n"
                    + "5.Generar Edades. \n"
                    + "6.Salir\n Opcion: ");
            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {

                case 1:
                    if (asesores.isEmpty()) {
                        System.out.println("No hay registros, cree un asesor para poder visualizarlo");
                    } else {
                        System.out.println("Listando Registros");
                        for (Asesor iterador : asesores) {
                            System.out.println("" + iterador);
                        }
                    }

                    break;
                case 2:
                    System.out.println("Regitrar Asesor.\n Ingrese cantidad de asesores a registrar: ");
                    int cant = Integer.parseInt(leer.nextLine());
                    for (int i = 0; i < cant; i++) {
                        try {
                            System.out.println("Ingrese cedula: ");
                            int cedula = Integer.parseInt(leer.nextLine());
                            System.out.println("Ingrese nombre: ");
                            String nombre = leer.nextLine();
                            System.out.println("Ingrese telefono: ");
                            int telefono = Integer.parseInt(leer.nextLine());
                            System.out.println("Ingrese fecha yyyy-mm-dd: ");
                            String fechaNacimiento = leer.nextLine();

                            System.out.println("Ingrese genero. \n 1.Femenino 2.Masculino");
                            String genero = leer.nextLine();
                            if (genero.equals(1)) {
                                genero = "Femenimo";
                            } else {
                                genero = "Masculino";
                            }
                            System.out.println("Ingrese cliente: ");
                            String cliente = leer.nextLine();
                            System.out.println("Ingrese sede: ");
                            String sede = leer.nextLine();
                                        if (genero.equals(1)) {
                                            sede = "Ruta N";
                                        } else if(genero.equals(2)){
                                            sede = "Puerto seco";
                                        }else{
                                            sede = "Buro";
                                        } 

                            Asesor asesorN = new Asesor(cedula, nombre, telefono, fechaNacimiento, genero, cliente, sede);
                            AsesorJDBC.insertar(asesorN);

                        } catch (NumberFormatException ex) {
                            throw new ExpecionTD("Ocurrio un error Ingrese tipo de dato correctamente");

                        } catch (Exception ex) {
                            System.out.println("Error: " + ex);
                        }
                    }

                    break;
                case 3:
                    boolean conf = false;
                    System.out.println("Ingrese cedula a actualizar: ");
                    int cedA = Integer.parseInt(leer.nextLine());

                    for (int i = 0; i < asesores.size(); i++) {
                        if (cedA == asesores.get(i).getCedula()) {
                            conf = true;
                            try {
                                int opc = 0;
                                int id = asesores.get(i).getId();
                                int cedula = asesores.get(i).getCedula();
                                String nombre = asesores.get(i).getNombre();
                                int telefono = asesores.get(i).getTelefono();
                                String fechaNacimiento = asesores.get(i).getFechaNacimiento();
                                String genero = asesores.get(i).getGenero();
                                String cliente = asesores.get(i).getCliente();
                                String sede = asesores.get(i).getSede();
                                do {
                                    System.out.println("Ingrese datos que desea actualizar \n"
                                            + "1.Cedula. \n"
                                            + "2.Nombre. \n"
                                            + "3.Telefono. \n"
                                            + "4.Fecha Nacimiento. \n"
                                            + "5.Genero. \n"
                                            + "6.Cliente. \n"
                                            + "7.Sede. \n "
                                            + "8.Salir. \n Opcion: ");
                                    opc = Integer.parseInt(leer.nextLine());

                                    if (opc == 1) {

                                        System.out.println("Cedula Anterior: " + asesores.get(i).getCedula());
                                        System.out.println("Ingrese cedula nueva: ");
                                        cedula = Integer.parseInt(leer.nextLine());
                                    }
                                    if (opc == 2) {
                                        System.out.println("Nombre Anterior: " + asesores.get(i).getNombre());
                                        System.out.println("Ingrese nombre: ");
                                        nombre = leer.nextLine();
                                    }
                                    if (opc == 3) {
                                        System.out.println("Telefono Anterior: " + asesores.get(i).getTelefono());
                                        System.out.println("Ingrese telefono");
                                        telefono = Integer.parseInt(leer.nextLine());
                                    }
                                    if (opc == 4) {
                                        System.out.println("Fecha Anterior: " + asesores.get(i).getFechaNacimiento());
                                        System.out.println("Ingrese fecha yyyy-mm-dd: ");
                                        fechaNacimiento = leer.nextLine();
                                    }
                                    if (opc == 5) {

                                        System.out.println("Genero Anterior: " + asesores.get(i).getGenero());
                                        System.out.println("Ingrese genero. \n 1.Femenino .Masculino");
                                        genero = leer.nextLine();
                                        if (genero.equals(1)) {
                                            genero = "Femenimo";
                                        } else {
                                            genero = "Masculino";
                                        }
                                    }
                                    if (opc == 6) {
                                        System.out.println("Cliente Anterior: " + asesores.get(i).getCliente());
                                        System.out.println("Ingrese cliente: ");
                                        cliente = leer.nextLine();
                                    }
                                    if (opc == 7) {
                                        System.out.println("Sede Anterior " + asesores.get(i).getCedula());
                                        System.out.println("Ingrese sede: \n 1.Ruta N \n 2.Puerto seco. \n 3.Buro");
                                        sede = leer.nextLine();
                                        if (genero.equals(1)) {
                                            sede = "Ruta N";
                                        } else if(genero.equals(2)){
                                            sede = "Puerto seco";
                                        }else{
                                            sede = "Buro";
                                        } 
                                            
                                            
                                    }
                                
                                    Asesor asesorN = new Asesor(cedula, nombre, telefono, fechaNacimiento, genero, cliente, sede, id);
                                    AsesorJDBC.actualizar(asesorN);

                                } while (opc != 8);

                            } catch (NumberFormatException ex) {
                                if (conf == true) {
                                    System.out.println("Se actualizo Correctamente");
                                }
                                throw new ExpecionTD("Ocurrio un error Ingrese tipo de dato correctamente");

                            } catch (Exception ex) {
                                System.out.println("Error= " + ex);
                            }
                        }
                    }
                    break;
                case 4:
                    boolean confE = false;
                    System.out.println("Estas es eliminar Asesor.\n Ingrese cedula de asesor a eliminar: ");
                    try {
                        int ced = Integer.parseInt(leer.nextLine());
                        Asesor asesorE = new Asesor(ced);
                        for (int i = 0; i < asesores.size(); i++) {
                            if (ced == asesores.get(i).getCedula()) {
                                AsesorJDBC.eliminar(asesorE);
                                confE = true;
                            }

                        }

                    } catch (NumberFormatException ex1) {
                        System.out.println("Ocurrio un error de tipo " + ex1.getMessage());
                        throw new Excepcion("Ocurrio un error (El tipo de dato ingresado es erroneo, porfavor ingrese un entero)");
                    }
                    System.out.println(confE == true ? "Registro Eliminado Correctamente" : "Asesor no econtrado, no se pudo realizar eliminacion");

                    break;

                case 5:
                    System.out.println("Asignado edades de acuerdo a fechas de nacimiento");
                    AsesorJDBC.generarEdades();
                    break;

                default:
                    System.out.println("Ingrese opcion correcta ");
                    break;

            }

        } while (opcion != 6);

    }

}
