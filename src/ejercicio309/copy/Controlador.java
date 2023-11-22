package ejercicio309.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	Vista vista;
	Modelo modelo;

	// CONSTRUCTOR DEL CONTROLADOR CON LA VISTA Y EL MODELO
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.updateTable(modelo.getStudentsList());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: USAR e.getActionCommand() PARA SABER QUE SE EST� EJECUTANDO
		// TODO: OBTENER PAR�METROS DE LA VISTA, OBTENER INFORMACI�N DE LOS ALUMNOS Y
		// ACTUALIZAR VALOR DE LA TABLA
		String actionC = e.getActionCommand();
		switch (actionC) {
			case "save":
				modelo.addStudent(vista.getDatos());
				break;
			case "update":
				modelo.modifyStudent(vista.getDatos());
				break;
			case "delete":
				modelo.deleteStudent(vista.getId());
				break;
			default:
				break;
		}

		vista.updateTable(modelo.getStudentsList());
	}
}
