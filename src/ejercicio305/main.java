package ejercicio305;

public class main {

    public static void main(String[] args) {

        // TODO: INSTANCIAR EL MODELO, LA VISTA Y EL CONTROLADOR
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, modelo);
        // TODO: ARRANCAR LA VISTA Y ESTABLECERLE EL CONTROLADOR
        vista.setControlador(controlador);
        vista.arranca();

    }
}
