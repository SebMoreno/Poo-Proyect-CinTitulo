package gestorAplicacion.usuario;

import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Pelicula;
import gestorAplicacion.cine.Sala;

public class Administrador extends Usuario {

    public Administrador(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Administrador(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE", false);
    }

    public Administrador(String usuario, String clave, String nombre, String email, boolean existe) {
        super(usuario, clave, "admin", nombre, email, existe);
        // opciones     "cerrar sesion","actualizar menu","editar pelicula"
    }

    private void createmovie(String titulo, String genero, String clasificacion, String duracion, String idioma, String sala) {
        Pelicula nueva = new Pelicula(titulo, genero, clasificacion, duracion, idioma, sala);
    }

    private void deletemovie(String titulo) {
        Pelicula.delete(titulo);
    }

    private void adminFuncionSala(Funcion funcion, Sala sala) {
        funcion.setSala(sala);
    }

    private void adminFuncionHora(Funcion funcion, String hora) {
        funcion.setHora(hora);
    }

    private void adminFuncionSetSillasOcupadas(Funcion funcion, short sillas) {
        funcion.setSillasOcupadas(sillas);
    }

    private void adminFuncionSetPelicula(Funcion funcion, Pelicula pelicula) {
        funcion.setPelicula(pelicula);
    }

    private void adminCreateFuncion(Sala sala, String hora, Pelicula pelicula) {
        Funcion nueva = new Funcion(sala, hora, pelicula);
    }

    private void adminDeleteFuncion(int id) {
        Funcion.deleteFuncion(id);
    }
}