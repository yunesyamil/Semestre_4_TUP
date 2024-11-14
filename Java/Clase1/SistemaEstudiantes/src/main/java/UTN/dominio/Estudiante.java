package UTN.dominio;

public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String telfono;
    private String email;

    public Estudiante() {
    } // Constructor vacio

    public Estudiante(int idEstudiante) { // Cosntructor para la llave primaria
        this.idEstudiante = idEstudiante;
    }

    // Constructor para insertar uyn nuevo estudiante
    public Estudiante(String nombre, String apellido, String telfono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telfono = telfono;
        this.email = email;
    }

    // Constructor para modicar
    public Estudiante(int idEstudiante, String nombre, String apellido, String telfono, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telfono = telfono;
        this.email = email;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelfono() {
        return telfono;
    }

    public void setTelfono(String telfono) {
        this.telfono = telfono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telfono='" + telfono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}