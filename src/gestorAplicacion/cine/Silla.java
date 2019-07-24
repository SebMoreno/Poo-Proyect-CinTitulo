package gestorAplicacion.cine;

import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;
import java.util.HashMap;
import java.util.Map;
//clase que crea las sillas , necesaria para boleta , sala (por la matriz) y para generar la boleta
//Estructuras:HashMap<String, String[]> sillasList,
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

    public static void RT() {////cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
        readTxt("sillas.txt", sillasList);
    }

    public Silla(String idSilla, Sala sala) {//Constructor para crear objetos que ya estan en los Txt
        this.idSilla = Integer.valueOf(idSilla);
        this.sala = sala;
        incremento = Short.valueOf(sillasList.get(idSilla)[0]);
        vibrosound = Boolean.parseBoolean(sillasList.get(idSilla)[1]);
        preferencial = Boolean.parseBoolean(sillasList.get(idSilla)[2]);
        ocupada = Boolean.parseBoolean(sillasList.get(idSilla)[3]);
        posicion = sillasList.get(idSilla)[4];
        posV = posicion.charAt(0);
        posH = posicion.charAt(2);
    }

    public Silla(Sala sala, int posV, int posH, boolean vibrosound, boolean preferencial, boolean ocupada) {//constructor al crear silla , tiene en cuenta el tipo para el incremento
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

    public static HashMap<String, String[]> getSillasList() {
        return sillasList;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {//al momento de comprar se llama este metodo para cambiar el booleano que determina eso
        this.ocupada = ocupada;
        String[] aux = sillasList.get(idSilla);
        aux[3] = Boolean.toString(ocupada);
        sillasList.put(Integer.toString(idSilla), aux);
    }

    public String getPosicion() {
        return posicion;
    }

    public int getIdSilla() {
        return idSilla;
    }

}
