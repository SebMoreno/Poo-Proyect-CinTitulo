package gestorAplicacion.usuario;

import java.util.HashMap;

public class Cuenta {
    
    private final Usuario propietario;
    private int saldo;
    private int idBoletas;
    private final HashMap<String, Integer[]> boletasList = new HashMap<>(); // key: usuario, value: idFuncion, estado
    public static final HashMap<String, Integer[]> cuentasList = new HashMap<>();

    static {
        baseDeDatos.RegistroCuenta.readTxt();

    }
    
    protected Cuenta(Usuario propietario) {
        this.propietario = propietario;
        Integer[] aux = {saldo, idBoletas};
        cuentasList.put(propietario.getUsuario(), aux);
        baseDeDatos.RegistroCuenta.writeTxt();
        this.idBoletas = cuentasList.size();
        baseDeDatos.RegistroBoletas.nuevaBoletasList(this.idBoletas);
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public int getSaldo() {
        return saldo;
    }

    public static HashMap<String, Integer[]> getCuentasList() {
        return cuentasList;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public HashMap<String, Integer[]> getBoletasList() {
        return boletasList;
    }
    

}
