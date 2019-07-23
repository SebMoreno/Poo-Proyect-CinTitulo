package gestorAplicacion.cine;

import static baseDeDatos.Registro.readTxt;
import static baseDeDatos.Registro.writeTxt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sala {

    private final int idSala;
    private final int precio;
    private final String tipo;
    private final int capacidad;
    final Silla[][] sillas;
    private final static HashMap<String, String[]> salasList = new HashMap<>(); // key: idSala     value: precio, tipo, capacidad, tamañoV, tamañoH idSilla[0][0], idSilla [0][1], ... , idSilla[n][n]

    public static void RT(){
        readTxt("salas.txt", salasList);
    }

    public Sala(String tipo, Silla[][] sillas) {
        this.sillas = sillas;
        this.tipo = tipo;
        switch (tipo) {
            case "2D":
                this.precio = 10000;
                break;
            case "3D":
                this.precio = 12000;
                break;
            case "IMAX":
                this.precio = 15000;
                break;
            case "DINAMIX":
                this.precio = 18000;
                break;
            default:
                this.precio = 10000;
        }
        int cap = 0;
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[0].length; j++) {
                if (sillas[i][j] != null) { //deberia cambiarse eso por un igual (?)
                    cap++;
                }
            }
        }
        this.capacidad = cap;
        int mayorId = 0, aux;
        for (Map.Entry<String, String[]> entry : salasList.entrySet()) {
            aux = Integer.valueOf(entry.getKey());
            if (mayorId < aux) {
                mayorId = aux;
            }
        }
        this.idSala = mayorId + 1;
        ArrayList<String> valor = new ArrayList<>();
        valor.add(Integer.toString(this.precio));
        valor.add(tipo);
        valor.add(Integer.toString(this.capacidad));
        valor.add(Integer.toString(sillas.length));
        valor.add(Integer.toString(sillas[0].length));
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[0].length; j++) {
                if (sillas[i][j] == null) {
                    valor.add("NA");
                } else {
                    valor.add(Integer.toString(sillas[i][j].getIdSilla()));
                }
            }
        }
        String[] value = new String[valor.size()];
        int i = 0;
        for (String iter : valor) {
            value[i] = iter;
            i++;
        }
        salasList.put(Integer.toString(idSala), value);
        writeTxt("salas.txt", salasList);
    }

    public int getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getIdSala() {
        return idSala;
    }

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
    
    public static HashMap<String, String[]> getSalasList() {
        return salasList;
    }
    

}
