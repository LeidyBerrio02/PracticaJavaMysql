package Test;

import Controlador.AsesorJDBC;
import Model.Asesor;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Implementacion {

    //Expresiones regulares 
    //valida texto
    //valida campo tipo numerico
    public static boolean validarNumero(String num) {
        if (num.matches("[0-9]*")) {
            return true;
        } else {
            return false;

        }
    }

    //valida campo tipo cedula
    public static boolean validarCedula(String cedula) {
        if (cedula.matches("[0-9]*{5,10}")) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validarFecha(String fecha) {
        if (fecha.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarTexto(String cadena) {
        if (cadena.matches("([a-zA-ZñÑáéíóúÁÉÍÓÚ]*[ ][a-zA-ZñÑáéíóúÁÉÍÓÚ]*){1,5}")) {
            return true;
        } else {
            return false;
        }
    }

    //Valida si el asesor con cedula x existe
    public static void validarExisteA(String cedu) throws Excepcion, ParseException {
        AsesorJDBC asesorJDBC = new AsesorJDBC();
        List<Asesor> asesores = asesorJDBC.select();
        for (int i = 0; i < asesores.size(); i++) {
            if (cedu.equals(asesores.get(i).getCedula())) {
                System.out.println("El usuario ya existente.");
                Menu.menu();
            }
        }

    }

    public static void mostrarAsesoresImpl(AsesorJDBC asesorJDBC, List<Asesor> asesores) {
        AsesorJDBC.generarEdades();
        if (asesores.isEmpty()) {
            System.out.println("No hay registros, cree un asesor para poder visualizarlo");
        } else {
            System.out.println("Listando Registros");
            for (Asesor iterador : asesores) {
                System.out.println("" + iterador.toString());
            }
        }
    }

    public static void registrarAsesorImp(Scanner leer) throws ParseException {
        System.out.println("Regitrar Asesor.\n Ingrese cantidad de asesores a registrar: ");
        int cant = Integer.parseInt(leer.nextLine());
        for (int i = 0; i < cant; i++) {
            try {
                System.out.println("Registro  = " + (i + 1));
                System.out.println("Ingrese cedula: " + (i + 1));
                String cedula = leer.nextLine();
                if (!validarCedula(cedula)) {
                    //Valida la existencia del asesor, ser falso continua con proceso
                    System.out.println("Tipo de dato incorrecto");
                } else {
                    validarExisteA(cedula);

                    System.out.println("Ingrese nombre completo: " + (i + 1));
                    String nombre = leer.nextLine();
                    if (!validarTexto(nombre)) {
                        System.out.println("El nombre solo puede tener letras y al menos nombre y apellido");
                    } else {
                        System.out.println("Ingrese telefono: " + (i + 1));
                        int telefono = Integer.parseInt(leer.nextLine());

                        System.out.println("Ingrese fecha yyyy-mm-dd: " + (i + 1));
                        String fechaNacimiento = leer.nextLine();
                        if (!validarFecha(fechaNacimiento)) {
                            System.out.println("Fecha incorrecta");
                        } else {
                            System.out.println("Ingrese genero. \n 1.Femenino 2.Masculino " + (i + 1));
                            String genero = leer.nextLine();
                            if (genero.equals(1)) {
                                genero = "Femenimo";
                            } else {
                                genero = "Masculino";
                            }
                            System.out.println("Ingrese cliente: " + (i + 1));
                            String cliente = leer.nextLine();
                            System.out.println("Ingrese sede: \n 1.Ruta N \n 2.Puerto seco. \n 3.Buro" + (i + 1));
                            String sede = leer.nextLine();
                            if (sede.equals(1)) {
                                sede = "Ruta N";
                            } else if (genero.equals(2)) {
                                sede = "Puerto seco";
                            } else {
                                sede = "Buro";
                            }

                            Asesor asesorN = new Asesor(cedula, nombre, telefono, fechaNacimiento, genero, cliente, sede);
                            AsesorJDBC.insertar(asesorN);
                        }

                    }
                }
            } catch (NumberFormatException ex) {
                throw new ExpecionTD("Ocurrio un error Ingrese tipo de dato correctamente");

            } catch (Excepcion ex) {
                System.out.println("Error de tipo " + ex);
            }
        }
    }

    public static void actualizarAsesorImp(Scanner leer, AsesorJDBC asesorJDBC, List<Asesor> asesores) {

        boolean conf = false;
        System.out.println("Ingrese cedula a actualizar: ");
        String cedA = leer.nextLine();

        for (int i = 0; i < asesores.size(); i++) {
            if (cedA.equals(asesores.get(i).getCedula())) {
                try {
                    /*
                    System.out.println("Cedula Anterior: " + asesores.get(i).getCedula());
                    System.out.println("Ingrese cedula nueva: ");
                    String cedula = leer.nextLine();
*/
                    System.out.println("Nombre Anterior: " + asesores.get(i).getNombre());
                    System.out.println("Ingrese nombre: ");
                    String nombre = leer.nextLine();

                    System.out.println("Telefono Anterior: " + asesores.get(i).getTelefono());
                    System.out.println("Ingrese telefono");
                    int telefono = Integer.parseInt(leer.nextLine());

                    System.out.println("Fecha Anterior: " + asesores.get(i).getFechaNacimiento());
                    System.out.println("Ingrese fecha yyyy-mm-dd: ");
                    String fechaNacimiento = leer.nextLine();

                    System.out.println("Genero Anterior: " + asesores.get(i).getGenero());
                    System.out.println("Ingrese genero. \n 1.Femenino 2.Masculino");
                    String genero = leer.nextLine();
                    if (genero.equals(1)) {
                        genero = "Femenimo";
                    } else {
                        genero = "Masculino";
                    }

                    System.out.println("Cliente Anterior: " + asesores.get(i).getCliente());
                    System.out.println("Ingrese cliente: ");
                    String cliente = leer.nextLine();

                    System.out.println("Sede Anterior " + asesores.get(i).getCedula());
                    System.out.println("Ingrese sede: \n 1.Ruta N \n 2.Puerto seco. \n 3.Buro");
                    String sede = leer.nextLine();
                    if (genero.equals(1)) {
                        sede = "Ruta N";
                    } else if (genero.equals(2)) {
                        sede = "Puerto seco";
                    } else {
                        sede = "Buro";
                    }
                    conf = true;
                    Asesor asesorN = new Asesor(cedA, nombre, telefono, fechaNacimiento, genero, cliente, sede);
                    AsesorJDBC.actualizar(asesorN);

                    System.out.println(conf == true ? "Registro Actualizado Correctamente" : "No se pudo realizar actualizacion");
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
    }

    public static void eliminarAsesorImp(Scanner leer, List<Asesor> asesores) throws Excepcion {
        boolean confE = false;
        System.out.println("Estas es eliminar Asesor.\n Ingrese cedula de asesor a eliminar: ");
        try {
            String ced = leer.nextLine();
            Asesor asesorE = new Asesor(ced);
            for (int i = 0; i < asesores.size(); i++) {
                if (ced.equals(asesores.get(i).getCedula())) {
                    AsesorJDBC.eliminar(asesorE);
                    confE = true;
                }

            }

        } catch (NumberFormatException ex1) {
            System.out.println("Ocurrio un error de tipo " + ex1.getMessage());
            throw new Excepcion("Ocurrio un error (El tipo de dato ingresado es erroneo, por favor ingrese un entero)");
        }
        System.out.println(confE == true ? "Registro Eliminado Correctamente" : "Asesor no econtrado, no se pudo realizar eliminacion");

    }

}
