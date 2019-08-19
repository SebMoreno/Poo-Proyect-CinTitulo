package gestorAplicacion.usuario;

import java.util.ArrayList;
import java.util.HashMap;

import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;

public class Cuenta {

	private final Cliente propietario;
	private int saldo;
	private final ArrayList<Integer> idBoletas = new ArrayList<>();
	public static final HashMap<String, String[]> cuentasList = new HashMap<>(); // key: usuario    value: saldo, idBoleta1, idBoleta2, ... , idBoletaN

	public static void RT() {//metodo necesario para leer el archivo donde se guardan las cuentas
		readTxt("cuentas.txt", cuentasList);
	}

	public Cuenta(Cliente propietario, boolean existe) {//tener en cuenta que una cuenta solo se genera cuando se crea un usuario  entonces recordar que en ocacione
		//se crea un usuario solo para acceder a metodo entonces tambien hay que tener ese filtro para no guardar una cuenta dos veces
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

	public Cliente getPropietario() {
		return propietario;
	}

	public int getSaldo() {
		return saldo;
	}

	public static HashMap<String, String[]> getCuentasList() {
		return cuentasList;
	}

	public ArrayList<Integer> getIdBoletas() {
		return idBoletas;
	}

	public void setSaldo(int saldo) {//metodo utilizado para reemplazar saldo
		this.saldo = saldo;
		String[] aux = cuentasList.get(propietario.getUsuario());
		aux[0] = Integer.toString(saldo);
		cuentasList.put(propietario.getUsuario(), aux);
	}

}
