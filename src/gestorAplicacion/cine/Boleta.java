 package gestorAplicacion.cine;

import static baseDeDatos.Registro.readTxt;
import static baseDeDatos.Registro.writeTxt;
import static gestorAplicacion.usuario.Cuenta.cuentasList;
import gestorAplicacion.usuario.Cuenta;
import java.util.HashMap;
import java.util.Map;

public class Boleta {

    private final Cuenta dueño;
    private final Funcion funcion;
    private final int idBoleta;
    private final Silla silla;
    private final int precio;
    private final static HashMap<String, String[]> boletasList = new HashMap<>(); // key: idBoleta     value: usuario, idFuncion, posicionSilla, precio

    public static void RT(){
        readTxt("cuentas.txt", cuentasList);
    }

    public Boleta(Cuenta dueño, Funcion funcion, Silla silla) {
        this.dueño = dueño;
        this.funcion = funcion;
        this.silla = silla;
        this.precio = funcion.getSala().getPrecio() + silla.getIncremento();
        int mayorId = 0, aux;
        for (Map.Entry<String, String[]> entry : boletasList.entrySet()) {
            aux = Integer.valueOf(entry.getKey());
            if (mayorId < aux) {
                mayorId = aux;
            }
        }
        this.idBoleta = mayorId + 1;
        String[] valor = {dueño.getPropietario().getUsuario(), Integer.toString(funcion.getIdFuncion()), silla.getPosicion(), Integer.toString(this.precio)};
        boletasList.put(Integer.toString(idBoleta), valor);
        writeTxt("cuentas.txt", cuentasList);
    }

    public Cuenta getDueño() {
        return dueño;

    }

    public static HashMap<String, String[]> getBoletasList(){
        return boletasList;
    }
    
    public Funcion getFuncion() {
        return funcion;
    }
    
    public int getPrecio(){
        return precio;
    }
}
