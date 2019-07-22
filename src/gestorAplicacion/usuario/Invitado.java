package gestorAplicacion.usuario;

import baseDeDatos.Registro;
import java.util.ArrayList;

public class Invitado extends Usuario {
    public static int numero_invitados = 0;
    public Invitado(int x) {
        super("invitado" + x, "NA", "NA", "NA ", "NE");
        String a[] = {"informacion pelicula","registrarse"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
        numero_invitados++;
    }
}
