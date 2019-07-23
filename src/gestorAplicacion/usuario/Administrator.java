package gestorAplicacion.usuario;

import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Pelicula;
import gestorAplicacion.cine.Sala;

public class Administrator extends Usuario {

    public Administrator(String usuario, String clave) {
        this(usuario, clave, "NA");
    }

    public Administrator(String usuario, String clave, String nombre) {
        this(usuario, clave, nombre, "NE", false);
    }

    public Administrator(String usuario, String clave, String nombre, String email, boolean existe) {
        super(usuario, clave, "admin", nombre, email, existe);
    }

    private void createmovie(String titulo, String genero, String clasificacion, String duracion, String idioma, String sala) {
        Pelicula nueva = new Pelicula(titulo, genero, clasificacion, duracion, idioma, sala);
    }

    private void deletemovie(String titulo) {
        Pelicula.delete(titulo);
    }

    private void modifyTheaterType(Sala sala, String tipo) {
        sala.setTipo(tipo);
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

    private void admincreateFuncion(Sala sala, String hora, Pelicula pelicula) {
        Funcion nueva = new Funcion(sala, hora, pelicula);
    }
    
}
