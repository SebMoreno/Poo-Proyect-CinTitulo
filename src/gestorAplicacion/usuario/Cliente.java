package gestorAplicacion.usuario;

import baseDeDatos.Registro;
import static gestorAplicacion.usuario.Usuario.menu;
import java.util.ArrayList;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

/**
 *
 * @author SebMoreno
 */
public class Cliente extends Usuario {

    private final Cuenta cuenta;

    static {
        ArrayList<OpcionDeMenu> options = new ArrayList<>();
        options.add(Registro.menu_generico.get("informacion pelicula"));
        options.add(Registro.menu_generico.get("comprar boleta"));
        options.add(Registro.menu_generico.get("reservar boleta"));
        options.add(Registro.menu_generico.get("ver informacion cuenta"));
        options.add(Registro.menu_generico.get("recargar"));
        options.add(Registro.menu_generico.get("terminar programa"));
        menu = new MenuDeConsola(options);
    }

    public Cliente(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Cliente(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE", false);
    }

    public Cliente(String usuario, String clave, String nombre, String email, boolean existe) {
        super(usuario, clave, "cliente", nombre, email, existe);
        this.cuenta = new Cuenta(this, existe);
        //opciones  "informacion pelicula","comprar pelicula","reservar pelicula","ver informacion cuenta","actualizar saldo"
    }

}
