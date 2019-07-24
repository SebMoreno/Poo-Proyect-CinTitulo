package gestorAplicacion.usuario;

/**
 *
 * @author SebMoreno
 */
public class Cliente extends Usuario {

    private final Cuenta cuenta;

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
