package gestorAplicacion.cine;

public class Funcion {

    private Sala sala;
    private final Silla[][] sillas = sala.sillas;
    private String hora;
    private int precio;
    private Short sillasOcupadas;
    private Pelicula pelicula;
    private  int idFuncion;
    private static int numFunciones;

    public Funcion(Sala sala, String hora, Pelicula pelicula) {
        this.sala = sala;
        this.hora = hora;
        this.pelicula = pelicula;
        numFunciones++;
        idFuncion = numFunciones;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Silla[][] getSillas() {
        return sillas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Short getSillasOcupadas() {
        return sillasOcupadas;
    }

}
