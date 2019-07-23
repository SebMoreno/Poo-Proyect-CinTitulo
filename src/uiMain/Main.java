package uiMain;

import baseDeDatos.Registro;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.cine.Sala;
import gestorAplicacion.cine.Silla;

public class Main {

    static public int navegador = 1;

    public static void main(String[] args) {

        Registro.readAllTxt();
        Registro.god_menu_birth();
        ArrayList<OpcionDeMenu> menu_1 = new ArrayList<>();
        menu_1.add(Registro.menu_generico.get("iniciar sesion"));
        menu_1.add(Registro.menu_generico.get("iniciar como invitado"));
        menu_1.add(Registro.menu_generico.get("salir"));
        MenuDeConsola menu_inicial = new MenuDeConsola(menu_1);
        menu_inicial.lanzarMenu();
        int option = 0;
        while (navegador != 0) {
            menu_1.get(option - 1).ejecutar();
        }

    }

}
