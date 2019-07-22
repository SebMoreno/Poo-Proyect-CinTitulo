package gestorAplicacion.usuario;

import baseDeDatos.Registro;

public class Administrator extends Usuario{

    public Administrator(String usuario, String clave) {
        this(usuario, clave, "NA");
        String a[] = {"actualizar menu","editar pelicula"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }

    public Administrator(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE");
        String a[] = {"actualizar menu","editar pelicula"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }

    public Administrator(String usuario, String clave, String nombre, String email) {
        super(usuario, clave, "admin", nombre, email);
        String a[] = {"actualizar menu","editar pelicula"};
        this.menu_user = Registro.MenuString_to_MenuOptions(a);
    }
    
}
