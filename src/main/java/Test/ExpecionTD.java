package Test;

//Se crea excepcion personalizada para cuando ocurra una poder mostrar el mensaje deseado
public class ExpecionTD extends NumberFormatException {

    public ExpecionTD(String mensaje) {
        super(mensaje);
    }

}
