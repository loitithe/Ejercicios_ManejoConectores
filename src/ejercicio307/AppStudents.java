package ejercicio307;

import java.util.Scanner;

public class AppStudents {
    private Student student;
    private Scanner sc;
    private int option;
    private ManageStudents manageStudents;
    private Conexion conexion;

    AppStudents() {
        sc = new Scanner(System.in);
        manageStudents = new ManageStudents();
        conexion = new Conexion();
        manageStudents.openConnection("school", "localhost", "root", "abc123");
        do {
            option = menuOpciones();
            switch (option) {

                case 1:
                    matriculaEstudiante();
                    break;
                case 2:
                    bajaEstudiante();
                    break;
                case 3:
                    updateEstudiante();
                    break;
                case 4:
                    verEstudiante();
                    break;
                case 5:
                    verEstudiantes();
                    break;
                case 0:
                    salir();
                    break;
                default:
                    break;
            }

        } while (option != 0);

    }

    int menuOpciones() {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "1.- MATRICULAR ESTUDIANTE\n2.- DAR DE BAJA ESTUDIANTE\n3.- ACTUALIZAR ESTUDIANTE\n4.- VER ESTUDIANTE\n5.- VER TODOS LOS ESTUDIANTES\n0.SALIR");
        try {
            option = sc.nextInt();
            return option;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    void matriculaEstudiante() {
        if (manageStudents.addStudent(manageStudents.createStudent())) {
            System.out.println("Estudiante matriculado");
        } else
            System.out.println("No se ha podido matricular");

    }

    void bajaEstudiante() {
        System.out.println("Introduce id del estudiante a eliminar :");
        String id = sc.nextLine();
        if (manageStudents.deleteStudent(id)) {
            System.out.println("Estudiante borrado correctamente");
        } else
            System.out.println("El estudiante no se ha podido eliminar");

    }

    void updateEstudiante() {
        if (manageStudents.modifyStudent()) {
            System.out.println("Estudiante modificado correctamente");
        }
    }

    void verEstudiante() {
        System.out.println("Introduce id del estudiante a comprobar :");
        String id = sc.next();
        manageStudents.getStudent(id);
        System.out.println(manageStudents.getStudent(id).toString());
    }

    void verEstudiantes() {
        manageStudents.getStudents();
    }

    void salir() {
    }

}
