package gestorAplicacion.usuario;

import baseDeDatos.Registro;
import gestorAplicacion.cine.Pelicula;

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
    private void createmovie(String titulo, String genero, String clasificacion, String duracion, String idioma,String sala){
        Pelicula nueva = new Pelicula(titulo, genero, clasificacion, duracion, idioma, sala);
    }
    private void deletemovie(String titulo){
        Pelicula.delete(titulo);
    }
}
