package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//boilerplate- Repetitivo
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiantes2024 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestudiantes2024;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}