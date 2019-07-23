package gestorAplicacion.usuario;

import baseDeDatos.Registro;

public class Administrator extends Usuario{

    public Administrator(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Administrator(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE", false);
    }

    public Administrator(String usuario, String clave, String nombre, String email, boolean existe) {
        super(usuario, clave, "admin", nombre, email, existe);
        String a[] = {"actualizar menu","editar pelicula"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }
    
}
