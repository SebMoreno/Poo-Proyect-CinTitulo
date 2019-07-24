package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuDeConsola {

    ArrayList<OpcionDeMenu> opciones = new ArrayList<>();

    public MenuDeConsola(ArrayList<OpcionDeMenu> options) {
        this.opciones = options;
    }

    public void Añadir_opcion(OpcionDeMenu option) {
        opciones.add(option);
    }

    public void lanzarMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=========================================");

        for (int i = 0; i < opciones.size(); i++) {
            System.out.println(i + " " + opciones.get(i));
        }
        System.out.print("Ingrese una opción: ");
        int opcion = scan.nextInt();
        opciones.get(opcion).ejecutar();
    }
}
