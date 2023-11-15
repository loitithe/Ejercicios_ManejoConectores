package ejercicio307;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;

    public void conexion(String bd, String server, String username, String password) {
        String url = String.format("jdbc:mysql://%s:3306:/%s", server, bd);
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            if (this.connection != null) {
                System.out.println("Conexion realizada correctamente");
            } else
                System.out.println("No se ha podido realizar la conexion");
        } catch (SQLException e) {
            System.out.println("SQLException :" + e.getLocalizedMessage());
            System.out.println("SQLState :" + e.getSQLState());
            System.out.println("Error code :" + e.getErrorCode());
        }

    }
}
