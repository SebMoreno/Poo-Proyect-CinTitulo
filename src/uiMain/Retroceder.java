package uiMain;

import static uiMain.Main.navegador;

public class Retroceder extends OpcionDeMenu {

    private final String titulomenu;

    public Retroceder(String s) {
        titulomenu = s;
    }

    public void ejecutar() {
        Main.navegador--;
    }

    public String toString() {
        if (navegador != 1) {
            return "Retroceder";
        } else {
            return titulomenu;
        }
    }
}
