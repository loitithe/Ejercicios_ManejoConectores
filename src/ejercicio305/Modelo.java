package ejercicio305;

import javax.swing.JTextField;

public class Modelo {

    // TODO: DEFINICIÓN DE LA FUNCIÓN DE SUMA
    public Double Sumar(JTextField jText_operando1, JTextField jText_operando2) {
        double suma = 0;
        try {
            double num1 = Double.parseDouble(jText_operando1.getText());
            double num2 = Double.parseDouble(jText_operando2.getText());
            suma = num1 + num2;
        } catch (NumberFormatException e) {
           e.printStackTrace();
        }
        return suma;
    }
}
