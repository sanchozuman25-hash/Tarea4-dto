package es.dam.ud1.series;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record SerieDTO(String titulo, Integer temporadas, String creador,
                       String categoria, String imagenPrincipal) {

    private static final String CREADOR_DESCONOCIDO = "Creador desconocido";
    private static final String SIN_CATEGORIA = "Sin categoría";

    /**
     * Transforma una Serie en SerieDTO de forma segura.
     * - serie null -> null
     * - sin creador / categoría -> texto por defecto
     * - imágenes null o vacía -> imagenPrincipal = null
     */
    public static SerieDTO from(Serie serie) {
        if (serie == null) {
            return null;
        }
        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                nombreCreador(serie.getCreador()),
                nombreCategoria(serie.getCategoria()),
                primeraImagen(serie.getImagenes()));
    }

    private static String nombreCreador(Creador creador) {
        if (creador == null) {
            return CREADOR_DESCONOCIDO;
        }
        String nombre = Stream.of(creador.getNombre(), creador.getApellidos())
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
        return nombre.isEmpty() ? CREADOR_DESCONOCIDO : nombre;
    }

    private static String nombreCategoria(Categoria categoria) {
        if (categoria == null || categoria.getNombre() == null || categoria.getNombre().isBlank()) {
            return SIN_CATEGORIA;
        }
        return categoria.getNombre();
    }

    private static String primeraImagen(List<String> imagenes) {
        if (imagenes == null || imagenes.isEmpty()) {
            return null;
        }
        return imagenes.get(0);
    }
}
