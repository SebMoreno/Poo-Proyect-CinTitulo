package uiMain;

import gestorAplicacion.usuario.Administrador;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Usuario;
import java.util.Scanner;

/**
 *
 * @author SebMoreno
 */
public class Registrarse extends OpcionDeMenu {

    private final String titulomenu = "Registrarse";

    public String toString() {
        return titulomenu;
    }

    @Override
    public void ejecutar() {
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
            nuevo = new Cliente(usuario, password, nombre, email, false);
            Main.menu = Cliente.getMenu();
        } else {
            nuevo = new Administrador(usuario, password, nombre, email, false);
            Main.menu = Administrador.getMenu();
        }
        Main.usuarioActivo = nuevo;
    }
}
