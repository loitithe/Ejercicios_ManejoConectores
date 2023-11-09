package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Conexion.JDBC;

public class Ejercicios {
    private static Scanner sc;
    private static Statement st;
    private static PreparedStatement ps;
    private static JDBC jdbc = new JDBC();
    private static ResultSet rs;
    private static Connection conexion;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        jdbc = new JDBC();
        sc = new Scanner(System.in);
        jdbc.openConexion("empleados", "localhost", "root", "abc123");
        conexion = jdbc.getConnection();
        // Consultas
        // String query_302A = "show tables from empleados;";
        // String query_302B = "select * from proyecto;";
        // ================EJERCICIO302============================ //
        /**
         * 1.Informacion de la base de datos;
         * jdbc.infoDatabase();
         * 
         * 2.Mostrar la información de la tabla proyectos.
         * consultasStatement(query_302B, "proyecto");
         * 
         * 3.Insertar un nuevo proyecto con los siguientes datos (11, 'Acceso a
         * datos',
         * 'Lugo', 3) en la tabla proyecto.
         * String query_302C = "INSERT INTO PROYECTO VALUES(11,'Acceso a
         * datos','Lugo',3)";
         * insertarFila(query_302C);
         * 
         * 4.Eliminar una fila de la tabla proyecto a partir de su número de proyecto
         * numproy.
         * String query_302D = "DELETE FROM PROYECTO WHERE NUMPROY=?;";
         * eliminarFila(query_302D, 11);
         */

        // ================EJERCICIO303============================ //
        /*
         * 
         * -Una clase llamada ConsultaNombres que devuelva los nombres de los empleados
         * que empiezan por una letra determinada. Esta letra será introducida por el
         * usuario.
         * consultaNombres();
         * -Una clase llamada BorradoEmpleados que permita borrar un empleado con un
         * número determinado. Este número será introducido por el usuario.
         * 
         * borradoEmpleados();
         */
        // ================EJERCICIO304============================ //
        /*
         * Implementa un programa en Java donde mediante una clase llamada
         * TransaccionEmpleado se permita insertar en la base de datos Empleados tres
         * nuevos contables: Pedro, Lucía y Daniel que pertenecerán al departamento 1.
         * 
         * ¿Qué pasa si hay un error al insertar alguno de los empleados?
         * 
         * Utiliza transacciones para controlar que se inserten los 3 empleados a la vez
         * y si ocurre un error, no se insertará ninguno.
         */
        transaccionEmpleado();

        jdbc.closeConexion();
    }

    private static void transaccionEmpleado() {
        int numFilasAfectadas = 0;
        String[] datos = new String[] { "3,'PEDRO',1", "2,'LUCIA',1", "1,'DANIEL',1" };
        String query = String.format("INSERT INTO (NSS,Nombre,Numdept) EMPLEADO VALUES(%s,%s,%d)");
        System.out.println();

        try {
            conexion.setAutoCommit(false);
            st = conexion.createStatement();
            for (int i = 0; i < datos.length; i++) {
                numFilasAfectadas += st.executeUpdate(query + datos[i]);
                conexion.commit();
            }
            System.out.println("filas afectadas " + numFilasAfectadas);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 
     * @param conexion
     * @param consulta
     * @param tabla
     */
    public static void consultasStatement(String query, String tabla) {
        try {
            st = conexion.createStatement();
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

    /**
     * 
     * @param query
     */
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

    /**
     * 
     * @param query
     * @param condicion
     */
    public static void eliminarFila(String query, int condicion) {
        try {
            if (ps == null) {
                ps = conexion.prepareStatement(query);
                ps.setInt(1, condicion);

            }
            int filasAfectadas = ps.executeUpdate();
            System.out.println(filasAfectadas);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void consultaNombres() {
        System.out.println("Introduce una letra para realizar la busqueda");
        String letra = sc.nextLine();
        String query = "SELECT NOMBRE FROM EMPLEADO WHERE NOMBRE LIKE ?;";
        try {
            if (ps == null) {
                ps = conexion.prepareStatement(query);
                ps.setString(1, letra);
                rs = ps.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void borradoEmpleados() {
        System.out.println("Introduce un numero para realizar el borrado");
        String query = "DELETE FROM EMPLEADO WHERE NSS = ?";
        int numero = sc.nextInt();
        try {
            if (ps == null) {
                ps = conexion.prepareStatement(query);
                ps.setInt(1, numero);
                int numFilasAfectadas = ps.executeUpdate();
                System.out.println("numero de filas afectadas : " + numFilasAfectadas);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
