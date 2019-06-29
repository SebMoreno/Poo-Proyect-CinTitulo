package gestorAplicacion.cine;

import java.util.ArrayList;
import java.util.HashMap;

public class Pelicula {

    private final String genero;
    private final String clasificacion;
    private final String titulo;
    private final String duracion;
    private final String idioma;
    private static HashMap<String, String[]> moviesList = new HashMap<>();

    public Pelicula(String genero, String clasificacion, String titulo, String duracion, String idioma) {
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.titulo = titulo;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getIdioma() {
        return idioma;
    }
    
    public static HashMap<String, String[]> getMoviesList() {
        return moviesList;
    }

}
