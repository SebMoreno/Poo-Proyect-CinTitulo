package uiMain;

public class Salir extends OpcionDeMenu {

    private final String titulomenu = "Terminar Programa";

    public void ejecutar() {
        System.exit(0);
    }

    public String toString() {
        return titulomenu;
    }
}
