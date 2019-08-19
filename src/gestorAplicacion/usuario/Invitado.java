package gestorAplicacion.usuario;

import uiMain.MenuDeConsola;

//usuario inicial que se puede registrar
public class Invitado extends Usuario {

	static MenuDeConsola menu;

	public Invitado() {//todo es por defecto
		super("invitado", "NA", "NA", "NA", "NE", true);
	}

	public static void setMenu(MenuDeConsola m) {
		menu = m;
	}

	public static MenuDeConsola getMenu() {
		return menu;
	}
}
