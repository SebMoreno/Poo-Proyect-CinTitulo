package uiMain;

import gestorAplicacion.usuario.Administrator;
import gestorAplicacion.usuario.Cliente;
import java.util.Scanner;

public class IniciarSesion extends OpcionDeMenu {

    private String titulomenu;
    private static String usuarioActivo;
    private Cliente cliente;
    private Administrator admin;

    Scanner scan = new Scanner(System.in);

    public IniciarSesion(String s) {
        this.titulomenu = s;
    }

    public void ejecutar() {
        Main.navegador++;
        System.out.println("Ingrese usuario");
        String nickname = scan.next();
        while (!gestorAplicacion.usuario.Usuario.getUsersList().containsKey(nickname)) {

            System.out.println("Usuario invalido");
            System.out.println("Ingrese nuevamente usuario");
            nickname = scan.next();
        }
        System.out.println("Ingrese contraseña");
        String pass = scan.next();
        String claveReal = gestorAplicacion.usuario.Usuario.getUsersList().get(nickname)[0];

        while (!claveReal.equals(pass)) {
            System.out.println("Contraseña invalida");
            System.out.println("Ingrese nuevamente la contraseña");
            pass = scan.next();

        }
        usuarioActivo = nickname;
        //falta resto del codigo para el menu
        String[] aux = gestorAplicacion.usuario.Usuario.getUsersList().get(nickname);// key: usuario    value: clave, rol, nombre, email
        if (aux[1].equals("cliente")) {
            cliente = new Cliente(nickname, pass, aux[2], aux[3], true);
            cliente.console_menu_user.lanzarMenu();
        } else if (aux[1].equals("admin")) {
            admin = new Administrator(nickname, pass, aux[2], aux[3], true);
            admin.console_menu_user.lanzarMenu();
        }
    }

    public static String getUsuarioActivo() {

        return usuarioActivo;
    }

    public String toString() {
        return titulomenu;
    }
}
