package gestorAplicacion.usuario;

/**
 *
 * @author SebMoreno
 */
public class Cliente extends Usuario{

    public Cliente(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Cliente(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE");
    }

    public Cliente(String usuario, String clave, String nombre, String email) {
        super(usuario, clave, "cliente", nombre, email);
    }

}
