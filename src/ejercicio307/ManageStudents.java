package ejercicio307;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudents {
    private Connection connection;
    private PreparedStatement ps;
    private Statement statement;
    private ResultSet resultSet;

    private int numFilasAfectadas;
    private ArrayList<Student> students;
    private Student student;
    private String query;
    private Scanner sc;

    ArrayList<Student> getStudentsList() {
        return students;
    }

    void openConnection(String bd, String server, String user, String password) {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", server, bd);
            this.connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conectado");

            } else
                System.out.println("No se ha podido conectar");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void closeConnection() {

        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean addStudent(Student student) {

        query = "INSERT INTO STUDENT VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSurname());
            ps.setInt(4, student.getAge());
            numFilasAfectadas = ps.executeUpdate();
            System.out.println("Filas afectadas = " + numFilasAfectadas);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    Student getStudent(String id) {

        query = "SELECT * FROM STUDENT WHERE ID=?";
        try {
            System.out.println("Modificando usuario... ");
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4));

                return student;
            }
            System.out.println("Filas afectadas = " + numFilasAfectadas);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return student;
    }

    boolean deleteStudent(String id) {
        query = "DELETE FROM STUDENT WHERE ID= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            numFilasAfectadas = ps.executeUpdate();
            System.out.println("Filas afectadas = " + numFilasAfectadas);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    boolean modifyStudent() {
        System.out.println("Introduce id del estudiante a modificar :");
        String id = sc.nextLine();
        student = createStudent();
        query = "UPDATE STUDENT SET ID = ?,NAME = ?, SURNAME= ?,AGE =? WHERE ID=?";

        try {
            System.out.println("Modificando usuario... ");
            ps = connection.prepareStatement(query);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSurname());
            ps.setInt(4, student.getAge());
            ps.setString(5, id);
            numFilasAfectadas = ps.executeUpdate();
            System.out.println("Filas afectadas = " + numFilasAfectadas);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    Student createStudent() {
        sc = new Scanner(System.in);
        String id, name, surname;
        int age;
        try {
            System.out.println("Introduce id");
            id = sc.nextLine();
            System.out.println("Introduce nombre");
            name = sc.nextLine();
            System.out.println("Introduce apellido");
            surname = sc.nextLine();
            System.out.println("Introduce edad");
            age = sc.nextInt();
            student = new Student(id, name, surname, age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;

    }

}
