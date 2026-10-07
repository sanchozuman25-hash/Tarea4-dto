package es.dam.ud1.series;

import java.util.ArrayList;
import java.util.List;

public class PruebaSeries {

    public static void main(String[] args) {
        Creador creador = new Creador(1L, "Vince", "Gilligan", "EE. UU.");
        Categoria drama = new Categoria(1L, "Drama", "Series dramáticas");
        List<String> imagenes = List.of("https://img.example.com/bb1.jpg", "https://img.example.com/bb2.jpg");

        Serie completa = new Serie(1L, "Breaking Bad", "Un profesor de química...", 5, creador, drama, imagenes);
        Serie sinCategoria = new Serie(2L, "Serie A", "Sinopsis A", 2, creador, null, imagenes);
        Serie sinCreador = new Serie(3L, "Serie B", "Sinopsis B", 1, null, drama, imagenes);
        Serie sinImagenes = new Serie(4L, "Serie C", "Sinopsis C", 3, creador, drama, null);
        Serie imagenesVacias = new Serie(5L, "Serie D", "Sinopsis D", 4, creador, drama, new ArrayList<>());

        System.out.println("Completa:        " + SerieDTO.from(completa));
        System.out.println("Sin categoría:   " + SerieDTO.from(sinCategoria));
        System.out.println("Sin creador:     " + SerieDTO.from(sinCreador));
        System.out.println("Sin imágenes:    " + SerieDTO.from(sinImagenes));
        System.out.println("Imágenes vacías: " + SerieDTO.from(imagenesVacias));
        System.out.println("Serie null:      " + SerieDTO.from(null));
    }
}
