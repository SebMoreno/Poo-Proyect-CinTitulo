package gestorAplicacion.usuario;

public class Administrator extends Usuario{

    public Administrator(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Administrator(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE");
    }

    public Administrator(String usuario, String clave, String nombre, String email) {
        super(usuario, clave, "admin", nombre, email);
    }
    
}
