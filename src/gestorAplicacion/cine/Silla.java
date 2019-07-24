package gestorAplicacion.cine;

import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;
import java.util.HashMap;
import java.util.Map;

public class Silla {

    private final boolean vibrosound;
    private final boolean preferencial;
    private final Short incremento;
    private final Sala sala;
    private final String posicion;
    private final int idSilla;
    private final int posV;
    private final int posH;
    private boolean ocupada;

    private final static HashMap<String, String[]> sillasList = new HashMap<>(); // key: idSilla     value: incremento, vibrosound, preferencial, ocupada, posicion, idSala

    public static void RT(){
        readTxt("sillas.txt", sillasList);
    }

    public Silla(Sala sala, int posV, int posH, boolean vibrosound, boolean preferencial, boolean ocupada) {
        this.sala = sala;
        this.posV = posV;
        this.posH = posH;
        this.posicion = Integer.toString(posV) + "." + Integer.toString(posH);
        this.vibrosound = vibrosound;
        this.preferencial = preferencial;
        this.ocupada = ocupada;
        if (vibrosound && preferencial) {
            this.incremento = 2000;
        } else if (vibrosound && !preferencial) {
            this.incremento = 1500;
        } else if (!vibrosound && preferencial) {
            this.incremento = 500;
        } else {
            this.incremento = 0;
        }
        int mayorId = 0, aux;
        for (Map.Entry<String, String[]> entry : sillasList.entrySet()) {
            aux = Integer.valueOf(entry.getKey());
            if (mayorId < aux) {
                mayorId = aux;
            }
        }
        this.idSilla = mayorId + 1;
        String[] valor = {Integer.toString(this.incremento), Boolean.toString(vibrosound), Boolean.toString(preferencial), Boolean.toString(ocupada), this.posicion, Integer.toString(this.sala.getIdSala())};
        sillasList.put(Integer.toString(idSilla), valor);
        writeTxt("sillas.txt", sillasList);
    }

    public Silla(Sala sala, int posV, int posH, boolean vibrosound, boolean preferencial) {
        this(sala, posV, posH, false, false, false);
    }

    public Silla(Sala sala, int posV, int posH) {
        this(sala, posV, posH, false, false);
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

    public String getPosicion() {
        return posicion;
    }

    public int getIdSilla() {
        return idSilla;
    }

}
