package gestorAplicacion.cine;

import static baseDeDatos.Registro.readTxt;
import static baseDeDatos.Registro.writeTxt;
import java.util.HashMap;

public class Pelicula {

    private final String genero;
    private final String clasificacion;
    private final String titulo;
    private final String duracion;
    private final String idioma;
    private final static HashMap<String, String[]> pelisList = new HashMap<>(); // key: titulo     value: genero, clasificacion, duracion, idioma

    static {
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
