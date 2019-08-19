package gestorAplicacion.usuario;

import uiMain.MenuDeConsola;
//clase que genera objetos tipo cliente heredada de usuarios
//ESTRUCTURAS: estan en la clase padre

public class Cliente extends Usuario {

	private final Cuenta cuenta;
	static MenuDeConsola menu;

	public Cliente(String usuario, String clave) {
		this(usuario, clave, "NA");
	}

	public Cliente(String usuario, String clave, String nombre) {
		this(usuario, clave, nombre, "NE", false);
	}

	public Cliente(String usuario, String clave, String nombre, String email, boolean existe) {//hay un boolean existe que es el que ayuda a crear objetos de ese tipo que no se quieren guardar en el txt(ya que solo se necesitan para llamar metodos y/o atributos
		super(usuario, clave, "cliente", nombre, email, existe);
		this.cuenta = new Cuenta(this, existe);
		//opciones  "informacion pelicula","comprar pelicula","reservar pelicula","ver informacion cuenta","actualizar saldo"
	}

	public static void setMenu(MenuDeConsola m) {
		menu = m;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public static MenuDeConsola getMenu() {
		return menu;
	}
}
