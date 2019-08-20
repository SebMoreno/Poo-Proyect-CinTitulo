/* en este paquete se maneja todas las clses con respecto al cine (Autores : todo el equipo) */
package model.cine;


import java.util.HashMap;
import java.util.Map;
import model.database.Data;
import model.user.Cliente;
import model.user.Cuenta;
import model.user.Usuario;

//Esta clase crea las boletas que se general cuando se compra , esta guardada tambien en la cuenta de su respectivo usuario
//ESTRUCTURAS:HashMap<String, String[]> boletasList(para registro de las boletas),
public class Boleta {

	private final static HashMap<String, String[]> boletasList = new HashMap<>(); // key: idBoleta     value: usuario, idFuncion, posicionSilla, precio
	private final Cuenta duenio;
	private final Funcion funcion;
	private final int idBoleta;
	private final Silla silla;
	private final int precio;


	public Boleta(String idBoleta) {//constructor solo con id , accediendo al hash puede obtener usuario , clave , nombre , email,silla , precio, ademas crea propietario con el booleano existe en true(explicacion en su respectivo contructor)
		String usuario = boletasList.get(idBoleta)[0];
		String clave = Usuario.getUsersList().get(usuario)[0];
		String nombre = Usuario.getUsersList().get(usuario)[2];
		String email = Usuario.getUsersList().get(usuario)[3];
		Cliente propietario = new Cliente(usuario, clave, nombre, email, true);
		duenio = new Cuenta(propietario, true);
		funcion = new Funcion(boletasList.get(idBoleta)[1]);
		this.idBoleta = Integer.parseInt(idBoleta);
		String posicionSilla = boletasList.get(idBoleta)[2];
		silla = funcion.getSala().getSilla(posicionSilla.charAt(0), posicionSilla.charAt(2));
		precio = Integer.parseInt(boletasList.get(idBoleta)[3]);
	}

	public Boleta(Cuenta duenio, Funcion funcion, Silla silla) {//Constructor originial de boleta y la guarda en su respectivo txt
		this.duenio = duenio;
		this.funcion = funcion;
		this.silla = silla;
		this.precio = funcion.getSala().getPrecio() + silla.getIncremento();
		int mayorId = 0, aux;
		for (Map.Entry<String, String[]> entry : boletasList.entrySet()) {
			aux = Integer.parseInt(entry.getKey());
			if (mayorId < aux) {
				mayorId = aux;
			}
		}
		this.idBoleta = mayorId + 1;
		String[] valor = {duenio.getPropietario().getUsuario(), Integer.toString(funcion.getIdFuncion()), silla.getPosicion(), Integer.toString(this.precio)};
		boletasList.put(Integer.toString(idBoleta), valor);
		String[] aux2 = new String[duenio.getIdBoletas().size() + 1];
		aux2[0] = Integer.toString(duenio.getSaldo());
		for (int i = 0; i < duenio.getIdBoletas().size(); i++) {
			aux2[i + 1] = Integer.toString(duenio.getIdBoletas().get(i));
		}
		Cuenta.getCuentasList().put(duenio.getPropietario().getUsuario(), aux2);

		Data.writeTxt("cuentas.txt", Cuenta.getCuentasList());
		Data.writeTxt("boletas.txt", boletasList);
		silla.setOcupada(true);
	}

	//cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
	public static void RT() {
		Data.readTxt("boletas.txt", boletasList);
	}


	public static HashMap<String, String[]> getBoletasList() {
		return boletasList;
	}

	public Cuenta getDuenio() {
		return duenio;

	}

	public Funcion getFuncion() {
		return funcion;
	}

	public int getPrecio() {
		return precio;
	}
}
