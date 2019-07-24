package uiMain;

import baseDeDatos.Registro;
import gestorAplicacion.usuario.Invitado;
import gestorAplicacion.usuario.Usuario;

public class Main {

    static public Usuario usuarioActivo;

    public static void main(String[] args) {

        Registro.initConfig();
        while (true) {
            usuarioActivo.getMenu().lanzarMenu();
        }
    }

}
