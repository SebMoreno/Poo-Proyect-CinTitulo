package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;

public class InformacionCuenta extends OpcionDeMenu {

    private final String titulomenu = "Mostrar la informacion de mi cuenta";

    @Override
    public void ejecutar() {
        Cliente us = (Cliente)Main.usuarioActivo;
        System.out.println("************" + "Cuenta del usuario " + us.getUsuario() + "************");
        System.out.println("Saldo: " + us.getCuenta().getSaldo());
        for (int i = 1; i < Cuenta.getCuentasList().get(us.getUsuario()).length; i++) {
            System.out.println("Boleta con ID: " + Cuenta.getCuentasList().get(us.getUsuario())[i]);
        }
    }

    @Override
    public String toString() {
        return titulomenu;
    }
}
