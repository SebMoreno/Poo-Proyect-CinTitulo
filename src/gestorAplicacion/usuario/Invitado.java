package gestorAplicacion.usuario;

import baseDeDatos.Registro;

public class Invitado extends Usuario {
    public static int numero_invitados;
    public Invitado() {
        
        super("invitado" + numero_invitados, "NA", "NA", "NA ", "NE");
        String a[] = {"informacion pelicula","registrarse"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
        numero_invitados++;
    }
}
