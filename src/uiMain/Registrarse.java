package uiMain;

import gestorAplicacion.cine.Bienvenida;
import gestorAplicacion.usuario.Administrador;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Usuario;

import java.util.Scanner;

//clase que registra usuarios invitador
public class Registrarse extends OpcionDeMenu implements Bienvenida {

	private final String titulomenu = "Registrarse";

	public String toString() {
		return titulomenu;
	}

	public void saludo() {
		System.out.println("Bienvenido");
	}

	@Override
	public void ejecutar() {//pide los datos al usuario para tener los parametros para llamar al construtor , dependiendo el rol que ingrese llama al constructor de cliente o de administrador
		Usuario nuevo;
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese un usuario: ");
		String usuario = scan.next();
		while (Usuario.getUsersList().containsKey(usuario)) {
			System.out.print("usuario ya usado\nIngrese un nombre de usuario diferente: ");
			usuario = scan.next();
		}
		System.out.print("Ingrese una contraseña: ");
		String password = scan.next();
		System.out.print("Ingrese su rol(\"cliente\" o \"admin\"): ");
		String rol = scan.next();
		while (!rol.equals("cliente") && !rol.equals("admin")) {
			System.out.println("Rol no valido");
			System.out.print("Ingrese un rol adecuado (\"cliente\" o \"admin\"): ");
			rol = scan.next();

		}
		System.out.print("Ingrese su email: ");
		String email = scan.next();
		System.out.print("Ingrese su nombre: ");
		String nombre = scan.next();

		if (rol.equals("cliente")) {
			nuevo = new Cliente(usuario, password, nombre, email, false);//boolean existe en false para que se pueda guardar en el txt
			Main.menu = Cliente.getMenu();
		} else {
			nuevo = new Administrador(usuario, password, nombre, email, false);
			Main.menu = Administrador.getMenu();
		}
		Main.usuarioActivo = nuevo;
		saludo();
	}
}
