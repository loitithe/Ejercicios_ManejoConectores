package ejercicio306;

import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {
    Connection conexion;

    // TODO: DEFINICIÓN DE LA CONEXIÓN CON LA BASE DE DATOS
    public void conexionDB(String bd, String server, String user, String password) {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", server, bd);
            this.conexion = DriverManager.getConnection(url, user, password);
            if (this.conexion != null) {
                System.out.println("Conectado a " + bd + " en " + server);

            } else
                System.out.println("No se ha podido conectar a " + bd);
        } catch (SQLException e) {
            System.out.println("SQLException :" + e.getLocalizedMessage());
            System.out.println("SQLState :" + e.getSQLState());
            System.out.println("Error code :" + e.getErrorCode());
        }
    }

    // TODO: CREAR FUNCIÓN PARA LA OBTENCIÓN DE LOS RESULTADOS DE LA CONSULTA
    public String getInfoUsuario(JTextField jTextField) {
        conexionDB("empleados", "localhost", "root", "abc123");
        String linea = null;
        try {
            int numUsuario = Integer.parseInt(jTextField.getText());
            Statement st = conexion.createStatement();
            String query = "select * from empleado where NSS =" + numUsuario;
            ResultSet rs = st.executeQuery(query);
            int numCols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= numCols; i++) {
                    linea += rs.getString(i) + " ";
                }

                return linea;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }finally{
            
        }
        return linea;
    }
}
