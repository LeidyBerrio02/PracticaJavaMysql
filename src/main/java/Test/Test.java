package Test;

import Controlador.AsesorJDBC;
import Model.Asesor;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Expecion {

        Scanner leer = new Scanner(System.in);

        int opcion = 0;
        AsesorJDBC asesorJDBC = new AsesorJDBC();
        List<Asesor> asesores = asesorJDBC.select();

        do {
            System.out.println("\n Menu Asesor Opciones: \n"
                    + "1.Mostrar Asesores. \n"
                    + "2.Crear Asesor(es). \n"
                    + "3.Actualizar Informacion. \n"
                    + "4.Eliminar Asesor. \n"
                    + "5.Salir\n Opcion: ");
            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {

                case 1:
                    System.out.println("Listando Registros");
                    for (Asesor iterador : asesores) {
                        System.out.println("" + iterador);
                    }
                    break;
                case 2:
                    System.out.println("Regitrar Asesor.\n Ingrese cantidad de asesores a registrar: ");
                    int cant = Integer.parseInt(leer.nextLine());
                    for (int i = 0; i < cant; i++) {
                        Asesor asesorN = new Asesor(1023810, "Juan camilo Uribe", 2454233, null, "M", "Cliente", "Sede");
                        AsesorJDBC.insertar(asesorN);
                    }

                    break;
                case 3:
                    break;
                case 4:
                    boolean confE = false;
                    System.out.println("Estas es eliminar Asesor.\n Ingrese cedula de asesor a eliminar");
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
                        throw new Expecion("Ocurrio un error (El tipo de dato ingresado es erroneo, porfavor ingrese un entero)");
                    }
                    System.out.println(confE == true ? "Registro Eliminado Correctamente" : "Asesor no econtrado, no se pudo realizar eliminacion");

                    break;

                default:
                    System.out.println("Ingrese opcion correcta ");
                    break;

            }

        } while (opcion != 5);

    }

}
