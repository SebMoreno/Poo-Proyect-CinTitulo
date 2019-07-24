package uiMain;

import gestorAplicacion.cine.Pelicula;
import java.util.Scanner;

public class AñadirPelicula extends OpcionDeMenu{
    
    private final String titulomenu = "Añadir Película";

    public void ejecutar() {
        Scanner esc = new Scanner(System.in);
        System.out.println("Escribe los datos de la nueva película");
        System.out.print("Titulo: ");
        String titulo = esc.next();
        System.out.println();
        while (Pelicula.getPelisList().containsKey(titulo)) {
            System.out.println("Una película con ese titulo ya existe, copia uno diferente");
            titulo = esc.next();
        }
        System.out.print("Genero: ");
        String genero = esc.next();
        System.out.print("Clasificación: ");
        String clasif = esc.next();
        System.out.print("Duración: ");
        String duracion = esc.next();
        System.out.print("Idioma: ");
        String idioma = esc.next();
        new Pelicula(titulo, genero, clasif, duracion, idioma);
    }

    public String toString() {
        return titulomenu;
    }
}

