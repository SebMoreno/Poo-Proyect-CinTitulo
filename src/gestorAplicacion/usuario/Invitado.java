package gestorAplicacion.usuario;

import baseDeDatos.Registro;
import java.util.ArrayList;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class Invitado extends Usuario {

    static {
        ArrayList<OpcionDeMenu> options = new ArrayList<>();        
        options.add(Registro.menu_generico.get("iniciar sesion"));
        options.add(Registro.menu_generico.get("iniciar como invitado"));
        options.add(Registro.menu_generico.get("terminar programa"));
        menu = new MenuDeConsola(options);
    }

    public Invitado() {
        super("invitado", "NA", "NA", "NA", "NE", true);
    }
}
