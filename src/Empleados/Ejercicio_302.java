package Empleados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.JDBC;

public class Ejercicio_302 {

    public static void consultasStatement(Connection conexion, String consulta) {
        try {
            Statement st = conexion.createStatement();
            String query = consulta;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt(0));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.openConexion(null, null, null, null);
        String consulta = "select * from empleados";
        consultasStatement(jdbc.getConnection(), consulta);
    }
}
