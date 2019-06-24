package gestorAplicacion.Cine;

public class Sala {

    private final int precio;
    private final Character tipo;
    private final Short capacidad;
    private final Silla[][] sillas;
    private Pelicula pelicula;
    private Short sillasOcupadas;

    public Sala(int precio, Character tipo, Short capacidad, Silla[][] sillas) {
        this.precio = precio;
        this.sillas = sillas;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public Sala(int precio, Character tipo, Short capacidad, Silla[][] sillas, Pelicula pelicula) {
        this(precio, tipo, capacidad, sillas);
        this.pelicula = pelicula;
    }

    public Sala(int precio, Character tipo, Short capacidad, Silla[][] sillas, Short sillasOcupadas) {
        this(precio, tipo, capacidad, sillas);
        this.sillasOcupadas = sillasOcupadas;
    }

    public int getPrecio() {
        return precio;
    }

    public Character getTipo() {
        return tipo;
    }

    public Short getCapacidad() {
        return capacidad;
    }

    public Silla[][] getSillas() {
        return sillas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Short getSillasOcupadas() {
        return sillasOcupadas;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setSillasOcupadas(Short sillasOcupadas) {
        this.sillasOcupadas = sillasOcupadas;
    }

}
