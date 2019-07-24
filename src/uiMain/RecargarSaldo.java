package uiMain;

import gestorAplicacion.usuario.Cliente;
import java.util.Scanner;

public class RecargarSaldo extends OpcionDeMenu {

    private final String titulomenu = "Recargar Saldo";

    @Override
    public void ejecutar() {
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
        cliente.getCuenta().setSaldo(saldo);
        System.out.println("Saldo actualizado correctamente");
    }

    @Override
    public String toString() {
        return titulomenu;
    }
}
