package gestorAplicacion.usuario;

import uiMain.MenuDeConsola;

public class Invitado extends Usuario {

    static MenuDeConsola menu;

    public Invitado() {
        super("invitado", "NA", "NA", "NA", "NE", true);
    }

    public static void setMenu(MenuDeConsola m) {
        menu = m;
    }
    public static MenuDeConsola getMenu() {
        return menu;
    }
}
