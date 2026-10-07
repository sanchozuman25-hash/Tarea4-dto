package es.dam.ud1.libros;

public class PruebaLibros {

    public static void main(String[] args) {
        Autor cervantes = new Autor(1L, "Miguel", "de Cervantes", "Saavedra", "Española");
        Autor orwell = new Autor(2L, "George", "Orwell", null, "Británica");
        Autor sinNombre = new Autor(3L, null, null, null, "Desconocida");

        Libro completo = new Libro(1L, "Don Quijote de la Mancha", "978-8420412146", 1605, 1376, cervantes);
        Libro sinApellido2 = new Libro(2L, "1984", "978-0451524935", 1949, 328, orwell);
        Libro sinAutor = new Libro(3L, "Libro anónimo", "978-0000000000", 1900, 100, null);
        Libro autorVacio = new Libro(4L, "Autor sin datos", "978-1111111111", 2000, 50, sinNombre);

        System.out.println("Completo:        " + LibroDTO.from(completo));
        System.out.println("Sin apellido2:   " + LibroDTO.from(sinApellido2));
        System.out.println("Sin autor:       " + LibroDTO.from(sinAutor));
        System.out.println("Autor sin datos: " + LibroDTO.from(autorVacio));
        System.out.println("Libro null:      " + LibroDTO.from(null));
    }
}
