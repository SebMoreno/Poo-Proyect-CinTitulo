package gestorAplicacion.cine;

public class Sala {

    private final int precio;
    private final char tipo;
    private final Short capacidad;
    final Silla[][] sillas;

    public Sala(int precio, char tipo, Short capacidad, Silla[][] sillas) {
        this.precio = precio;
        this.sillas = sillas;
        this.tipo = tipo;
        this.capacidad = capacidad;
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

    /* REVISAR LOGICA  */
    public Silla getSilla(int posicionX, int posicionY) {
        if (posicionX <= sillas.length) {
            if (posicionY <= sillas[0].length) {
                return sillas[posicionX][posicionY];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    /* FIN REVISAR LOGICA */

}
