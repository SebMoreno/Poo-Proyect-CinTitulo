package gestorAplicacion.Cine;

public class Silla {

    private final boolean vibrosound;
    private final boolean preferencial;
    private final Short incremento;
    private final Sala sala;
    private boolean ocupada;

    public Silla(Sala sala, boolean vibrosound, boolean preferencial) {
        this.sala = sala;
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

    public Silla(Sala sala, boolean vibrosound, boolean preferencial, boolean ocupada) {
        this(sala, vibrosound, preferencial);
        this.ocupada = ocupada;
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
