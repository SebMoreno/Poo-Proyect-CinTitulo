package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
//opcion informacion cuenta dispoible para usuarios registrados
public class InformacionCuenta extends OpcionDeMenu {

    private final String titulomenu = "Mostrar la informacion de mi cuenta";

    @Override
    public void ejecutar() {//accede al hash he imprime todas las keys y values(recordar que los values de nuestros hash map son arreglos, tiene en cuenta el usuario con el que se incio sesion
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
