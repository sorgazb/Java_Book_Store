package sob.tienda_libros.servicio;

import sob.tienda_libros.modelo.Libro;

import java.util.List;

public interface ILibroServicio {
    public List<Libro> listarLibros();

    public Libro buscarLibroPorId(int idLibro);

    public void guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
}
