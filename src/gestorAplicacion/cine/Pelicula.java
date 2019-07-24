package gestorAplicacion.cine;

import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;
import java.util.HashMap;

public class Pelicula {

    private final String genero;
    private final String clasificacion;
    private final String titulo;
    private final String duracion;
    private final String idioma;
    private final static HashMap<String, String[]> pelisList = new HashMap<>(); // key: titulo     value: genero, clasificacion, duracion, idioma, sala

    public static void RT() {
        readTxt("peliculas.txt", pelisList);
    } 

    public Pelicula(String titulo, String genero, String clasificacion, String duracion, String idioma) {
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.titulo = titulo;
        this.duracion = duracion;
        this.idioma = idioma;
        while (pelisList.containsKey(titulo)) {
            System.out.println("pelicula ya ingresada");//Programar para mostrar error y perdir nueva pelicula
        }
        String[] aux = {genero, clasificacion, duracion, idioma};
        pelisList.put(titulo, aux);
        writeTxt("peliculas.txt", pelisList);
    }

    public static void delete(String titulo) {
        if (pelisList.containsKey(titulo)) {
            System.out.println("Haz borrado " + pelisList.remove(titulo) + " de la cartelera");
        } else {
            System.out.println("El título de esa película no está registrado\nNo se ha realizado ninguna modificación");
        }
        writeTxt("peliculas.txt", pelisList);
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

    public static HashMap<String, String[]> getPelisList() {
        return pelisList;
    }

}
