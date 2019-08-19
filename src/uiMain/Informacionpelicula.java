package uiMain;

//opcion informacion pelicula disponible para todos los usuarios
public class Informacionpelicula extends OpcionDeMenu {

	private final String titulomenu = "Mostrar listado de películas";

	@Override
	public String toString() {
		return titulomenu;
	}

	@Override
	public void ejecutar() {
		imprimirPeliculas();

	}

	static void imprimirPeliculas() {//accede al hash he imprime todas las keys y values(recordar que los values de nuestros hash map son arreglos)
		System.out.println("//////////////////Lista de las películas//////////////////");
		if (!gestorAplicacion.cine.Pelicula.getPelisList().isEmpty()) {
			for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Pelicula.getPelisList().entrySet()) {
				System.out.println("************" + entry.getKey() + "************");
				System.out.println("genero: " + entry.getValue()[0]);
				System.out.println("clasificación: " + entry.getValue()[1]);
				System.out.println("duracion: " + entry.getValue()[2]);
				System.out.println("idioma: " + entry.getValue()[3]);
			}
		} else {
			System.out.println("No hay peliculas ahora mismo");
		}
	}

	//Verificar que el programa funciona con la beta creada en la base de datos.
}
