package ejercicio306;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    private Vista vista;
    private Modelo modelo;
    // TODO: CONSTRUCTOR DEL CONTROLADOR CON LA VISTA Y EL MODELO

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: USAR e.getActionCommand() PARA SABER QUE SE ESTÁ EJECUTANDO
        // TODO: OBTENER PARÁMETROS DE LA VISTA, OBTENER INFORMACIÓN USUARIO Y PINTAR EL
        // VALOR EN LA VISTA
        if (e.getActionCommand().equals("button_buscar")) {
            String resultado = modelo.getInfoUsuario(vista.getjTextField1());
            if (resultado != null) {
                vista.setjTextArea1(resultado);
            } else
                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "ERROR",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
}
