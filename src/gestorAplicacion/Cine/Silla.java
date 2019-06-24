package gestorAplicacion.Cine;

public class Silla {

    private final byte[] posicion = new byte[2];
    private final boolean vibrosound;
    private final boolean preferencial;
    private final Short incremento;
    private final Sala sala;
    private boolean ocupada;

    public Silla(Sala sala, boolean vibrosound, boolean preferencial, byte posicionX, byte posicionY) {
        this.sala = sala;
        this.posicion[0] = posicion[posicionX];
        this.posicion[1] = posicion[posicionY];
        this.vibrosound = vibrosound;
        this.preferencial = preferencial;
        if (vibrosound && preferencial) {
            this.incremento = 2000;
        } else if (vibrosound && !preferencial) {
            this.incremento = 1500;
        } else if (!vibrosound && preferencial) {
            this.incremento = 500;
        } else {
            this.incremento = 0;
        }
    }

    public Silla(Sala sala, boolean vibrosound, boolean preferencial, byte posicionX, byte posicionY, boolean ocupada) {
        this(sala, vibrosound, preferencial, posicionX, posicionY);
        this.ocupada = ocupada;
    }

    public byte[] getPosicion() {
        return posicion;
    }

    public boolean isVibrosound() {
        return vibrosound;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public Short getIncremento() {
        return incremento;
    }

    public Sala getSala() {
        return sala;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

}
