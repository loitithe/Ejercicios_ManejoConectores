package ejercicio306;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {

        // TODO: INSTANCIAR EL MODELO, LA VISTA Y EL CONTROLADOR
        // TODO: ARRANCAR LA VISTA Y ESTABLECERLER EL CONTROLADOR
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, modelo);
        vista.setControlador(controlador);
        vista.arrancar();
    }

}
