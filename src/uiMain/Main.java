package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.usuario.Usuario;

public class Main {

    static public Usuario usuarioActivo;
    static public MenuDeConsola menu;

    public static void main(String[] args) {
        
        Data.initConfig();
        while (true) {
            menu.lanzarMenu();
        }
        
    }

}
