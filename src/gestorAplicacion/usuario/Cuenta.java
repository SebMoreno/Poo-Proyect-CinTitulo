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

    public static void RT(){
        readTxt("cuentas.txt", cuentasList);
    }

    protected Cuenta(Usuario propietario, boolean existe) {
        this.propietario = propietario;
        if (existe) {
            this.saldo = Integer.valueOf(cuentasList.get(propietario.getUsuario())[0]);
            for (int i = 1; i < cuentasList.get(propietario.getUsuario()).length; i++) {
                this.idBoletas.add(Integer.valueOf(cuentasList.get(propietario.getUsuario())[i]));
            }

        } else {
            String[] aux = new String[idBoletas.size() + 1];
            aux[0] = Integer.toString(saldo);
            for (int i = 0; i < idBoletas.size(); i++) {
                aux[i + 1] = Integer.toString(idBoletas.get(i));
            }
            cuentasList.put(propietario.getUsuario(), aux);
            writeTxt("cuentas.txt", cuentasList);
        }
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
