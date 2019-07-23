package gestorAplicacion.usuario;

import baseDeDatos.Registro;

/**
 *
 * @author SebMoreno
 */
public class Cliente extends Usuario{

    public Cliente(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Cliente(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE", false);
    }

    public Cliente(String usuario, String clave, String nombre, String email, boolean existe) {
        super(usuario, clave, "cliente", nombre, email, existe);
        //opciones  "informacion pelicula","comprar pelicula","reservar pelicula","ver informacion cuenta","actualizar saldo"
        this.menu_user.add(Registro.menu_generico.get("informacion pelicula"));
        this.menu_user.add(Registro.menu_generico.get("comprar pelicula"));
        this.menu_user.add(Registro.menu_generico.get("reservar pelicula"));
        this.menu_user.add(Registro.menu_generico.get("ver informacion cuenta"));
        this.menu_user.add(Registro.menu_generico.get("actualizar saldo"));
        this.menu_user.add(Registro.menu_generico.get("salir"));
    }

}
