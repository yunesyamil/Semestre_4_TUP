package UTN.presentacion;

import UTN.datos.EstudianteDAO;
import UTN.conexion.Conexion;
import UTN.dominio.Estudiante;


import javax.swing.*;
import java.util.List;

public class SistemaEstudianteApp {
    public static void main(String[] args) {
        var conexion = Conexion.getConnection();
        if (conexion != null)
            System.out.println("Conexión exitosa: " + conexion);
        else
            System.out.println("Error al conectarse");
        menu();
    }//Fin main

    public static void menu() {
        String[] opciones = {
                "Listar estudiantes",
                "Buscar Estudiantes",
                "Agregar estudiante",
                "Modificar estudiante",
                "Eliminar estudiante",
                "Salir"};
        String seleccion = "";
        do {
            // ? Mostrar el cuadro de diálogo con el menú desplegable
            seleccion = (String) JOptionPane.showInputDialog(null, "Elige una opción", "Menú",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (seleccion) {
                case "Listar estudiantes":
                    Listar();
                    break;
                case "Buscar Estudiantes":
                    buscar();
                    break;
                case "Agregar estudiante":
                    agregar();
                    break;
                case "Modificar estudiante":
                    modificar();
                    break;
                case "Eliminar estudiante":
                    eliminar();
                    break;
            }
        } while (seleccion != "Salir");
        JOptionPane.showMessageDialog(null, "Hasta luego vuelva pronto");
    }

    public static void Listar() {
        EstudianteDAO estudiantesDao = new EstudianteDAO();
        List<Estudiante> estudiantes = estudiantesDao.listarEstudiantes();
        // TODO creamos el metodo builder para
        StringBuilder mensaje = new StringBuilder();

        for (Estudiante estudiante : estudiantes) {
            mensaje.append(estudiante.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Lista de Estudiantes", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void buscar() {
        EstudianteDAO estudiantesDao = new EstudianteDAO();
        int estudianteid = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                estudianteid = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del alumno a buscar"));
                validInput = true;
                var estudiante1 = new Estudiante(estudianteid);
                var econtrado = estudiantesDao.buscarEstudiantePorId(estudiante1);
                if (econtrado) {
                    JOptionPane.showMessageDialog(null, "Se encontro exitosamente estudiante id: " + estudianteid);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro id: " + estudianteid);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error ingrese un valor valido ");
            }
        }

    }

    public static void agregar() {
        EstudianteDAO estudiantesDao = new EstudianteDAO();
//        String nombre1 = JOptionPane.showInputDialog(null, "Ingrese el nombre del alumno:");
//        String apellido1 = JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno");
//        String telefono1 = JOptionPane.showInputDialog(null, "Ingrese el numero telefonico");
//        String email1 = JOptionPane.showInputDialog(null, "Ingrese su email");
//        var estudiante1 = new Estudiante(nombre1, apellido1, telefono1, email1);
        var estudiante1 = new Estudiante();
        estudiante1.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del alumno:"));
        estudiante1.setApellido(JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno"));
        estudiante1.setTelfono(JOptionPane.showInputDialog(null, "Ingrese el numero telefonico"));
        estudiante1.setEmail(JOptionPane.showInputDialog(null, "Ingrese su email"));
        var agregado = estudiantesDao.agregarEstudiante(estudiante1);
        if (agregado) {
            JOptionPane.showMessageDialog(null, "Se agrego estudiante: " + estudiante1.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se cargo estudiante " + estudiante1.toString());
        }
    }

    public static void modificar() {
        EstudianteDAO estudiantesDao = new EstudianteDAO();
        Listar();
        var estudiante1 = new Estudiante();
        boolean existe = false;
        while (!existe) {

            estudiante1.setIdEstudiante(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese id de estudiante a modificar")));
            var verificador = estudiantesDao.buscarEstudiantePorId(estudiante1);
            if (verificador) {
                estudiante1.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del alumno:"));
                estudiante1.setApellido(JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno"));
                estudiante1.setTelfono(JOptionPane.showInputDialog(null, "Ingrese el numero telefonico"));
                estudiante1.setEmail(JOptionPane.showInputDialog(null, "Ingrese su email"));
                existe = true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe usuario a modificar con id:" + estudiante1.getIdEstudiante());
            }

        }
        var agregado = estudiantesDao.modificarEstudiante(estudiante1);
        if (agregado) {
            JOptionPane.showMessageDialog(null, "Se modifico estudiante: " + estudiante1.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No modifico estudiante " + estudiante1.toString());
        }

    }
    public static void eliminar() {
        EstudianteDAO estudiantesDao = new EstudianteDAO();
        int estudianteid = 0;
        boolean validInput = false;
        Listar();
        while (!validInput) {
            try {
                estudianteid = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del alumno a eliminar"));
                validInput = true;
                var estudiante1 = new Estudiante(estudianteid);
                var eliminado1 = estudiantesDao.eliminarEstudiante(estudiante1);
                if (eliminado1) {
                    JOptionPane.showMessageDialog(null, "Se elimino exitosamente estudiante id: " + estudianteid);
                } else {
                    JOptionPane.showMessageDialog(null, "No se elimino id: " + estudianteid);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error ingrese un valor valido ");
            }
        }

    }
}// Fin clase