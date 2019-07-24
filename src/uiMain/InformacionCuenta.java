package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;

public class InformacionCuenta extends OpcionDeMenu {

    private final String titulomenu = "Mostrar la informacion de mi cuenta";

    @Override
    public void ejecutar() {
        String nick = Main.usuarioActivo.getUsuario();
        Cuenta cuenta = new Cuenta((Cliente) Main.usuarioActivo, true);
        System.out.println("************" + "Cuenta del usuario " + nick + "************");
        System.out.println("Saldo: " + cuenta.getSaldo());
        for (int i = 1; i < Cuenta.getCuentasList().get(nick).length; i++) {
            System.out.println("Boleta con ID: " + Cuenta.getCuentasList().get(nick)[i]);
        }
    }

    @Override
    public String toString() {
        return titulomenu;
    }
}
