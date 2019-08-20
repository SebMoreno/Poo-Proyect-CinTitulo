package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.cine.Boleta;
import gestorAplicacion.cine.Funcion;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import java.util.Map;
import java.util.Scanner;

//opcion de menu para comprar boleta , solo pueden accer usuarios clientes
public class ComprarBoleta extends OpcionDeMenu {

	private String titulomenu = "Comprar Boleta";

	@Override
	public void ejecutar() {
		Informacionpelicula.imprimirPeliculas();//metodo que imprime todas las peliculas
		System.out.print("Escoja una pelicula\nEscribe el titulo de la pelicula exactamente como aparece: ");
		Scanner entrada = new Scanner(System.in);
		String titulo = entrada.next();
		int i = 0;
		for (Map.Entry<String, String[]> entry : Funcion.getFuncionesList().entrySet()) {//busca todas las funciones de esa pelicula
			if (entry.getValue()[1].equals(titulo)) {
				System.out.println("************" + "Funcion " + entry.getKey() + "************");
				System.out.println("Sala: " + entry.getValue()[0]);
				System.out.println("Titulo pelicula: " + entry.getValue()[1]);
				System.out.println("Hora: " + entry.getValue()[2]);
				System.out.println("Sillas ocupadas: " + entry.getValue()[3]);
				i++;
			}
		}
		if (i == 0) {
			System.out.println("No hay funciones con esa pelicula ahora mismo");
		}
		System.out.print("Escoja una funcion\nEscribe el numero de la funcion: ");
		String funcion = entrada.next();
		Funcion F = new Funcion(funcion);//crea un objeto tipo funcion para acceder a los atributos y metodos
		System.out.println(F.getSala());
		System.out.println("\nElija la silla que desee");
		System.out.println("El significado de las letras es:");
		System.out.println("P: premium, es decir, vibrosound y preferenciales a la vez\n"
				+ "        v: vibrosound\n"
				+ "        p: preferenciales\n"
				+ "        n: normales\n"
				+ "        \n"
				+ "        Acompañada a esta letra siempre estará o una L(silla libre) o una O(silla ocupada)");
		System.out.println("\n");
		System.out.print("Ingrese la coordenada vertical: ");
		int posicionV = entrada.nextInt();
		System.out.print("Ingrese la coordenada horizontal: ");
		int posicionH = entrada.nextInt();
		while (F.getSala().getSilla(posicionV, posicionH).isOcupada()) {//verifica en el hash de sillas si la silla esta ocupada
			System.out.println("La silla está ocupada, Intente otra por favor");
			System.out.print("Ingrese la coordenada vertical: ");
			posicionV = entrada.nextInt();
			System.out.print("Ingrese la coordenada horizontal: ");
			posicionH = entrada.nextInt();
		}

		Cliente cliente = (Cliente) Main.usuarioActivo;//necesita al usuario que esta tratando de acceder para saber cual es su saldo en cuenta
		int precioBoleta = F.getSala().getPrecio() + F.getSala().getSilla(posicionV, posicionH).getIncremento();
		if (cliente.getCuenta().getSaldo() >= precioBoleta) {
			Boleta boleta = new Boleta(cliente.getCuenta(), F, F.getSala().getSilla(posicionV, posicionH));//crea un objeto tipo boleta y ademas los gurda en cuenta
			Data.writeTxt("boletas.txt", Boleta.getBoletasList());//lo gurda en el txt de boletas(en la clase boleta no se guarda)
			int saldo_nuevo = cliente.getCuenta().getSaldo() - precioBoleta;
			cliente.getCuenta().setSaldo(saldo_nuevo);//para cambiar el saldo en la cuenta
			Data.writeTxt("cuentas.txt", Cuenta.getCuentasList());
			short ocupadas = F.getSillasOcupadas();
			ocupadas++;//aumenta las silla ocupadas en la sala
			F.setSillasOcupadas(ocupadas);
			System.out.println("Su compra fue realizada con éxito");
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public String toString() {
		return titulomenu;
	}
}
