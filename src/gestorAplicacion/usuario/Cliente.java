package gestorAplicacion.usuario;

import baseDeDatos.Registro;

/**
 *
 * @author SebMoreno
 */
public class Cliente extends Usuario{

    public Cliente(String usuario, String clave) {
        this(usuario, clave, "NA");
        String a[] = {"informacion pelicula","comprar pelicula","reservar pelicula","ver informacion cuenta","actualizar saldo"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }

    public Cliente(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE");
        String a[] = {"iniciar sesion","cerrar sesion","informacion pelicula","comprar pelicula","reservar pelicula","ver informacion cuenta","actualizar saldo"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }

    public Cliente(String usuario, String clave, String nombre, String email) {
        super(usuario, clave, "cliente", nombre, email);
        String a[] = {"informacion pelicula","comprar pelicula","reservar pelicula","ver informacion cuenta","actualizar saldo"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }

}
