package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.cine.Pelicula;

import java.util.Scanner;

//opcion de menu para borrar peliculas (es unica de administrador)
public class EliminarPelicula extends OpcionDeMenu {

	private String titulomenu = "Eliminar Pelicula";
	Scanner input = new Scanner(System.in);

	@Override
	public void ejecutar() {//elimina la pelicula del hash he invoca al write para escribir nuevamente en el txt
		Informacionpelicula.imprimirPeliculas();
		System.out.println("Ingrese el título exacto de la película a eliminar");
		String titulo = input.next();
		gestorAplicacion.cine.Pelicula.getPelisList().remove(titulo);
		Data.writeTxt("peliculas.txt", Pelicula.getPelisList());
		System.out.println("¡Película eliminada con exito!");
	}

	@Override
	public String toString() {
		return titulomenu;
	}

}

