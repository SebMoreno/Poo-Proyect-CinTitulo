package uiMain;

import java.util.Scanner;

public class EliminarPelicula extends OpcionDeMenu {
    
    private String titulomenu = "Eliminar Pelicula";
    Scanner input = new Scanner (System.in);
    @Override
    public void ejecutar() {
        System.out.println("Ingrese el título de la película a eliminar");
        Informacionpelicula.imprimirPeliculas();
        String titulo = input.next();
        gestorAplicacion.cine.Pelicula.getPelisList().remove(titulo);
        System.out.println("¡Película eliminada con exito!");
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}

