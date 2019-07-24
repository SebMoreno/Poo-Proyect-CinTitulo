package uiMain;

import gestorAplicacion.usuario.Administrador;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Usuario;
import java.util.Scanner;

public class IniciarSesion extends OpcionDeMenu {

    private final String titulomenu = "Iniciar Sesion";

    private Cliente cliente;
    private Administrador admin;

    public String toString() {
        return titulomenu;
    }

    public void ejecutar() {
        Usuario nuevo;
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        String usuario = scan.next();
        while (!Usuario.getUsersList().containsKey(usuario)) {
            System.out.print("Este usuario no existe\nIngrese uno ya creado: ");
            usuario = scan.next();
        }
        System.out.print("Ingrese su contraseña: ");
        String password = scan.next();
        while (!Usuario.getUsersList().get(usuario)[0].equals(password)) {
            System.out.print("Contraseña inválida\nIngrese la contraseña nuevamente: ");
            usuario = scan.next();
        }
        String rol = Usuario.getUsersList().get(usuario)[1];
        if (rol.equals("cliente")) {
            nuevo = new Cliente(usuario, password, Usuario.getUsersList().get(usuario)[2], Usuario.getUsersList().get(usuario)[3], true);
            Main.menu = Cliente.getMenu();
        } else {
            nuevo = new Administrador(usuario, password, Usuario.getUsersList().get(usuario)[2], Usuario.getUsersList().get(usuario)[3], true);
            Main.menu = Administrador.getMenu();
        }
        Main.usuarioActivo = nuevo;
    }

}
