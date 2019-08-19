package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;

import java.util.Scanner;

import static baseDeDatos.Data.writeTxt;

//clase que solo pueden acceder usuarios cliente
public class RecargarSaldo extends OpcionDeMenu {

	private final String titulomenu = "Recargar Saldo";

	@Override
	public void ejecutar() {//suma el saldo nuevo al anterior  editandolo en el hashmap y posteriormente escribiendolo en el txt
		Scanner scan = new Scanner(System.in);
		String nick = Main.usuarioActivo.getUsuario();
		Cliente cliente = (Cliente) Main.usuarioActivo;
		System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo());
		System.out.print("Ingrese saldo a recargar: ");
		int saldo = scan.nextInt();
		while (saldo <= 0) {
			System.out.print("Ingrese Saldo válido: ");
			saldo = scan.nextInt();
		}
		cliente.getCuenta().setSaldo(cliente.getCuenta().getSaldo() + saldo);
		writeTxt("cuentas.txt", Cuenta.getCuentasList());
		System.out.println("Saldo actualizado correctamente");
	}

	@Override
	public String toString() {
		return titulomenu;
	}
}
