package gestorAplicacion.usuario;

import java.util.HashMap;

public class Cuenta {
    
    private final Usuario propietario;
    private int saldo;
    private int idBoletas= baseDeDatos.RegistroBoletas.getCantidadArchivos();
    
    public static final HashMap<String, Integer[]> cuentasList = new HashMap<>(); // key: usuario    value: saldo, idBoletas

    
    protected Cuenta(Usuario propietario) {
        baseDeDatos.Registro r = new baseDeDatos.RegistroCuenta();
        r.readTxt();
        this.propietario = propietario;
        Integer[] aux = {saldo, idBoletas};
        cuentasList.put(propietario.getUsuario(), aux);
        r.writeTxt();
        this.idBoletas = cuentasList.size();
        gestorAplicacion.cine.Boleta.nuevaBoletasList(this.idBoletas);
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
    

}
