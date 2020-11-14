package Test;

import Controlador.AsesorJDBC;
import Model.Asesor;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void menu() throws Excepcion, ParseException {

        Scanner leer = new Scanner(System.in);
        //SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-mm-dd");

        int opcion = 0;
        //Creacion de objetos de clase asesorJDBC y una lista de clase asesor para obtener metodos
        AsesorJDBC asesorJDBC = new AsesorJDBC();
        List<Asesor> asesores = asesorJDBC.select();

        //menu que se ejecutara hasta que el usuario ingrese la opcion 5
        do {
            System.out.println("\n Menu Asesor Opciones: \n"
                    + "1.Mostrar Asesores. \n"
                    + "2.Crear Asesor(es). \n"
                    + "3.Actualizar Informacion. \n"
                    + "4.Eliminar Asesor. \n"
                    + "5.Salir\n Opcion: ");
            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {

                //llamando los metodos y se ejedutaran de acuerdo a la opcion ingreada por el cliente
                case 1:
                    Implementacion.mostrarAsesoresImpl(asesorJDBC, asesores);
                    break;
                case 2:
                    Implementacion.registrarAsesorImp(leer);
                    break;
                case 3:
                    Implementacion.actualizarAsesorImp(leer, asesorJDBC, asesores);
                    break;
                case 4:
                    Implementacion.eliminarAsesorImp(leer, asesores);
                    break;
                default:
                    System.out.println("Ingrese opcion correcta ");
                    break;

            }

        } while (opcion != 5);//condicion mientras

    }

}
