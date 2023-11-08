package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.JDBC;

public class Ejercicio_302 {
    private static Statement st;
    private static PreparedStatement ps;
    private static JDBC jdbc;
    private static ResultSet rs;

    public static void consultasStatement(Connection conexion, String consulta, String tabla) {
        try {
            st = conexion.createStatement();
            String query = consulta;
            rs = st.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + " : " + rs.getString(i) + "\n");
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void insertarFila(String query) {

        try {
            st = jdbc.getConnection().createStatement();
            int numFilasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas " + numFilasAfectadas);
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void eliminarFila(String query, int condicion) {
        try {
            if (ps == null) {
                ps = jdbc.getConnection().prepareStatement(query);
                ps.setInt(1, condicion);

            }
            int filasAfectadas = ps.executeUpdate();
            System.out.println(filasAfectadas);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        jdbc = new JDBC();
        jdbc.openConexion("empleados", "localhost", "root", "abc123");
        // String query_302A = "show tables from empleados;";
        // String query_302B = "select * from proyecto;";
        // Informacion de la base de datos;
        // jdbc.infoDatabase();
        // consultasStatement(jdbc.getConnection(), query_302B, "proyecto");

        // Insertar un nuevo proyecto con los siguientes datos (11, 'Acceso a datos',
        // 'Lugo', 3) en la tabla proyecto.
        String query_302C = "INSERT INTO PROYECTO VALUES(11,'Acceso a datos','Lugo',3)";
        // insertarFila(query_302C);
        // Eliminar una fila de la tabla proyecto a partir de su número de proyecto
        // numproy.
        // String query_302D = "DELETE FROM PROYECTO WHERE NUMPROY=?;";
        // eliminarFila(query_302D, 11);
        jdbc.closeConexion();
    }
}
