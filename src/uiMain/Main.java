package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.usuario.Usuario;

public class Main {

    static public Usuario usuarioActivo;

    public static void main(String[] args) {

        Data.initConfig();
        while (true) {
            usuarioActivo.getMenu().lanzarMenu();
        }
    }

}
