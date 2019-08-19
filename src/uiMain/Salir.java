package uiMain;

//clase para salir del programa
public class Salir extends OpcionDeMenu {

	private final String titulomenu = "Terminar Programa";

	public void ejecutar() {//salir del programa
		System.exit(0);
	}

	public String toString() {
		return titulomenu;
	}
}
