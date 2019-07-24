package uiMain;

public class Salir extends OpcionDeMenu {

    private final String titulomenu;

    public Salir(String s) {
        titulomenu = s;
    }

    public void ejecutar() {
        System.exit(0);
    }

    public String toString() {
        return "Terminar programa";
    }
}
