
package ejercicio309.copy;

public class Main {

	public static void main(String[] args) {
		// TODO: INSTANCIAR EL MODELO, LA VISTA Y EL CONTROLADOR
		// TODO: ARRANCHAR LA VISTA Y ESTABLECERLE EL CONTROLADOR
		// TODO: ACTUALIZAR LA TABLA CON LA LISTA DE TODOS LOS ALUMNOS
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		vista.arrancar();
		Controlador controlador = new Controlador(vista, modelo);
		vista.setControlador(controlador);

	}

}
