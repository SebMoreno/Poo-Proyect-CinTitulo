package gestorAplicacion.cine;

import static baseDeDatos.Registro.readTxt;
import static baseDeDatos.Registro.writeTxt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sala {

    private final int idSala;
    private int precio;
    private final String tipo;
    private final int capacidad;
    final Silla[][] sillas;
    private final static HashMap<String, String[]> salasList = new HashMap<>(); // key: idSala     value: precio, tipo, capacidad, tamañoV, tamañoH idSilla[0][0], idSilla [0][1], ... , idSilla[n][n]

    public static void RT() {
        readTxt("salas.txt", salasList);
    }

    public Sala(String tipo, int tamañoVertical, int tamañoHorizontal, int filasVibrosound, int filasPreferencial) {
        this.sillas = crearMatrizSillas(tamañoVertical, tamañoHorizontal, filasVibrosound, filasPreferencial);
        this.capacidad = tamañoVertical * tamañoHorizontal;
        /*Se le asigna un ID nuevo a la sala*/
        int mayorId = 0, aux;
        for (Map.Entry<String, String[]> entry : salasList.entrySet()) {
            aux = Integer.valueOf(entry.getKey());
            if (mayorId < aux) {
                mayorId = aux;
            }
        }
        this.idSala = mayorId + 1;
        /*Se le asigna el precio segun tipo de sala*/
        switch (tipo) {
            case "2D":
                this.tipo = tipo;
                this.precio = 10000;
                break;
            case "3D":
                this.tipo = tipo;
                this.precio = 12000;
                break;
            case "IMAX":
                this.tipo = tipo;
                this.precio = 15000;
                break;
            case "DINAMIX":
                this.tipo = tipo;
                this.precio = 18000;
                break;
            default:
                this.tipo = "2D";
                this.precio = 10000;
        }
        /*Empieza el proceso de guardado en el Txt*/
        ArrayList<String> valor = new ArrayList<>();
        valor.add(Integer.toString(this.precio));
        valor.add(this.tipo);
        valor.add(Integer.toString(this.capacidad));
        valor.add(Integer.toString(sillas.length));
        valor.add(Integer.toString(sillas[0].length));
        int i = 0;
        for (i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[0].length; j++) {
                if (sillas[i][j] == null) {
                    valor.add("NA");/*Revisar papi*/
                } else {
                    valor.add(Integer.toString(sillas[i][j].getIdSilla()));
                }
            }
        }

        String[] value = new String[valor.size()];
        i = 0;
        for (String iter : valor) {
            value[i] = iter;
            i++;
        }
        salasList.put(Integer.toString(idSala), value);
        writeTxt("salas.txt", salasList);
    }

    private Silla[][] crearMatrizSillas(int tamañoVertical, int tamañoHorizontal, int filasVibrosound, int filasPreferencial) {
        Silla[][] s = new Silla[tamañoVertical][tamañoHorizontal];
        int val = filasVibrosound - filasPreferencial;
        if (val > 0) {
            for (int i = 0; i < filasPreferencial; i++) {
                for (int j = 0; j < tamañoHorizontal; j++) {
                    s[i][j] = new Silla(this, i, j, true, true, false);
                }
            }
            for (int i = filasPreferencial; i < filasVibrosound; i++) {
                for (int j = 0; j < tamañoHorizontal; j++) {
                    s[i][j] = new Silla(this, i, j, true, false, false);
                }
            }
            for (int i = filasVibrosound; i < tamañoVertical; i++) {
                for (int j = 0; j < tamañoHorizontal; j++) {
                    s[i][j] = new Silla(this, i, j, false, false, false);
                }
            }
        } else {
            for (int i = 0; i < filasVibrosound; i++) {
                for (int j = 0; j < tamañoHorizontal; j++) {
                    s[i][j] = new Silla(this, i, j, true, true, false);
                }
            }
            for (int i = filasVibrosound; i < filasPreferencial; i++) {
                for (int j = 0; j < tamañoHorizontal; j++) {
                    s[i][j] = new Silla(this, i, j, false, true, false);
                }
            }
            for (int i = filasPreferencial; i < tamañoVertical; i++) {
                for (int j = 0; j < tamañoHorizontal; j++) {
                    s[i][j] = new Silla(this, i, j, false, false, false);
                }
            }
        }
        return s;
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

    public Silla[][] getSillas() {
        return sillas;
    }

    /*Imprime todos los lugares de las sillas por consola mostrando si son:
        P: premium, es decir, vibrosound y preferenciales a la vez
        v: vibrosound
        p: preferenciales
        n: normales
        
        Acompañada a esta letra siempre estará o una L(silla libre) o una O(silla ocupada)
     */
    @Override
    public String toString() {
        String sala = "";

        for (int i = 0; i < this.sillas.length; i++) {
            for (int j = 0; j < this.sillas[0].length; j++) {
                if (this.getSillas()[i][j].isOcupada()) {
                    if (this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
                        sala += "";
                        sala += "PO ";
                    } else if (!this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
                        sala += "vO ";
                    } else if (this.getSillas()[i][j].isPreferencial() && !this.getSillas()[i][j].isVibrosound()) {
                        sala += "pO ";
                    } else {
                        sala += "nO ";
                    }
                } else {
                    if (this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
                        sala += "PL ";
                    } else if (!this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
                        sala += "vL ";
                    } else if (this.getSillas()[i][j].isPreferencial() && !this.getSillas()[i][j].isVibrosound()) {
                        sala += "pL ";
                    } else {
                        sala += "nL ";
                    }
                }
            }
            sala += "\n";
        }
        return sala;
    }

}
