package gestorAplicacion.usuario;

public class Invitado extends Usuario {

    public Invitado(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Invitado(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE");
    }

    public Invitado(String usuario, String clave, String nombre, String email) {
        super(usuario, clave, "invitado", nombre, email);
    }

}
