package Conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC {
    private Connection connection;
    private DatabaseMetaData metadatos;
    private ResultSet rst, rsp;
    private ResultSetMetaData resultSetMetaData;

    public void openConexion(String bd, String server, String user, String password) {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", server, bd);
            this.connection = DriverManager.getConnection(url, user, password);
            if (this.connection != null) {
                System.out.println("Conectado a " + bd + " en " + server);
                setMetadatos(connection.getMetaData());

            } else
                System.out.println("No se ha conectado a " + bd);
        } catch (SQLException e) {
            System.out.println("SQLException :" + e.getLocalizedMessage());
            System.out.println("SQLState :" + e.getSQLState());
            System.out.println("Error code :" + e.getErrorCode());
        }
    }

    public void infoDatabase() {
        try {
            System.out.println("Nombre del producto : " + this.metadatos.getDatabaseProductName());
            System.out.println("Version del producto : " + this.metadatos.getDatabaseProductVersion());
            System.out.println("Nombre del driver : " + this.metadatos.getDriverName());
            System.out.println("Version del driver : " + this.metadatos.getDriverVersion());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void mostrarTablas(ResultSet rst) {
        String tabla = "";
        try {
            while (rst.next()) {
                tabla = rst.getObject(3).toString();
                System.out.println("nombre de la tabla : " + tabla);
                // recoger primary key
                rsp = metadatos.getPrimaryKeys(null, null, tabla);
                if (rsp.next())
                    System.out.println("Primary Key: " + rsp.getObject(4));
                rsp.close();

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void closeConexion() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion " + e.getLocalizedMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public DatabaseMetaData getMetadatos() throws SQLException {
        return this.connection.getMetaData();
    }

    public void setMetadatos(DatabaseMetaData metadatos) {
        this.metadatos = metadatos;
    }

    public void getNumCols() {

    }
}
