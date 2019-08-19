//clase de las opciones y se encuentra la clase principal main , toda la ligadura dinamica esta aqui (Autores : todo el equipo)

package uiMain;

import gestorAplicacion.cine.Pelicula;

import java.util.Scanner;

//opcion de menu para añadir peliculas (es unica de administrador)
public class AñadirPelicula extends OpcionDeMenu {

	private final String titulomenu = "Añadir Película";

	public void ejecutar() {//metodo abstracto heredado opcion de menú
		Scanner esc = new Scanner(System.in);
		System.out.println("Escribe los datos de la nueva película");
		System.out.print("Titulo: ");
		String titulo = esc.next();
		System.out.println();
		while (Pelicula.getPelisList().containsKey(titulo)) {//verifica que no quiera añadir una pelicula que ya existe
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
		new Pelicula(titulo, genero, clasif, duracion, idioma);//cuando llama al constructor el se encarga de guardarlo en el txt
	}

	public String toString() {
		return titulomenu;
	}
}

