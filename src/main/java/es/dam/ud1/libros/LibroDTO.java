package es.dam.ud1.libros;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LibroDTO(String titulo, String isbn, String autor, Integer anioPublicacion) {

    private static final String AUTOR_DESCONOCIDO = "Autor desconocido";

    /**
     * Transforma un Libro en LibroDTO de forma segura.
     * Devuelve null si el libro es null.
     */
    public static LibroDTO from(Libro libro) {
        if (libro == null) {
            return null;
        }
        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreCompleto(libro.getAutor()),
                libro.getAnioPublicacion());
    }

    private static String nombreCompleto(Autor autor) {
        if (autor == null) {
            return AUTOR_DESCONOCIDO;
        }
        String nombre = Stream.of(autor.getNombre(), autor.getApellido1(), autor.getApellido2())
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
        return nombre.isEmpty() ? AUTOR_DESCONOCIDO : nombre;
    }
}
