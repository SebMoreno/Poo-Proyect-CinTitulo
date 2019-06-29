package uiMain;

import java.util.*;

public class Informacionpelicula extends OpcionDeMenu {
//imprime la información de todas las peliculas
    Scanner entrada = new Scanner(System.in);
    private String titulomenu;
    
    Informacionpelicula(String s){
        this.titulomenu=s;
    }
    
    @Override
    public void ejecutar() {
        for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Pelicula.getMoviesList().entrySet()) {
                System.out.println("            " + entry.getKey() + "          ");
                System.out.println("genero: " + entry.getValue()[0] + "         " + "clasificación: " + entry.getValue()[1]);
                System.out.println("duración: " + entry.getValue()[2] + "           " + "idioma: " + entry.getValue()[3]);
            }
    }

    @Override
    public String toString() {
        return titulomenu;
    }
   
 //Verificar que el programa funciona con la beta creada en la base de datos.   
    
}
