package uiMain;

import gestorAplicacion.usuario.Administrator;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Usuario;
import java.util.Scanner;

public class IniciarSesion extends OpcionDeMenu {

    private final String titulomenu = "Iniciar Sesion";

    private static String usuarioActivo;
    private Cliente cliente;
    private Administrator admin;

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
        } else {
            nuevo = new Administrator(usuario, password, Usuario.getUsersList().get(usuario)[2], Usuario.getUsersList().get(usuario)[3], true);
        }
        Main.usuarioActivo = nuevo;
    }

    public static String getUsuarioActivo() {

        return usuarioActivo;
    }

}
