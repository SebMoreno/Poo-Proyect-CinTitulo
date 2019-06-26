package gestorAplicacion.usuario;

import java.util.HashMap;

public class Cuenta {

    private final Usuario propietario;
    private int saldo;
    private int idBoletas;
    private static HashMap<String, String[]> cuentasList = new HashMap<>();

    protected Cuenta(Usuario propietario) {
        this.propietario = propietario;
    }

    protected Cuenta(Usuario propietario, int saldo) {
        this(propietario);
        this.saldo = saldo;
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
