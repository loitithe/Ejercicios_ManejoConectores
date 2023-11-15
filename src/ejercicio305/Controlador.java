package ejercicio305;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private Vista vista;
    private Modelo modelo;

    // TODO CONSTRUCTOR DEL CONTROLADOR CON LA VISTA Y EL MODELO
    Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: USAR e.getActionCommand() PARA SABER QUE SE ESTÁ EJECUTANDO
        // TODO: OBTENER PARÁMETROS DE LA VISTA, LLAMAR A SUMAR Y PINTAR EL VALOR EN LA
        // VISTA
        if (e.getActionCommand().equals("button_sumar")) {
            double resultado = modelo.Sumar(vista.getOperando1(), vista.getOperando2());
            vista.setJTextPane("" + resultado);
        }
    }
}
