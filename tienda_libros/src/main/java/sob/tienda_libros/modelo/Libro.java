package sob.tienda_libros.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libro {
    //Atributos de la clase Libro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idLibro;
    String nombreLibro;
    String autorLibro;
    double precioLibro;
    int existenciasLibro;

}
