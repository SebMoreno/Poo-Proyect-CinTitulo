package gestorAplicacion.usuario;

import static baseDeDatos.Registro.readTxt;
import static baseDeDatos.Registro.writeTxt;
import java.util.ArrayList;
import java.util.HashMap;

public class Cuenta {

    private final Usuario propietario;
    private int saldo;
    private final ArrayList<Integer> idBoletas = new ArrayList<>();
    public static final HashMap<String, String[]> cuentasList = new HashMap<>(); // key: usuario    value: saldo, idBoleta1, idBoleta2, ... , idBoletaN

    static {
        readTxt("cuentas.txt", cuentasList);
    }

    protected Cuenta(Usuario propietario) {
        this.propietario = propietario;
        String[] aux = new String[idBoletas.size() + 1];
        aux[0] = Integer.toString(saldo);
        for (int i = 0; i < idBoletas.size(); i++) {
            aux[i + 1] = Integer.toString(idBoletas.get(i));
        }
        cuentasList.put(propietario.getUsuario(), aux);
        writeTxt("cuentas.txt", cuentasList);
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public int getSaldo() {
        return saldo;
    }

    public static HashMap<String, String[]> getCuentasList() {
        return cuentasList;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
