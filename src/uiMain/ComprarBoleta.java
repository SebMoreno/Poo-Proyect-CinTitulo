package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.cine.Boleta;
import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Sala;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ComprarBoleta extends OpcionDeMenu {

    private String titulomenu = "Comprar Boleta";

    @Override
    public void ejecutar() {
        System.out.println("Escoja una pelicula\nEscribe el titulo de la pelicula exactamente como aparece");
        Informacionpelicula.imprimirPeliculas();
        Scanner entrada = new Scanner(System.in);
        String titulo = entrada.next();
        System.out.println("Seleccione el numero de la funcion deseada");
        InformacionFunciones.imprimirFunciones();
        System.out.println("Escoja una funcion\nEscribe el numero de la funcion");
        String funcion = entrada.next();
        Funcion F = new Funcion(funcion);
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
        System.out.println("Ingrese la coordenada vertical");
        int posicionV = entrada.nextInt();
        System.out.println("Ingrese la coordenada horizontal");
        int posicionH = entrada.nextInt();
        Cliente cliente = (Cliente) Main.usuarioActivo;
        int precioBoleta = F.getSala().getPrecio() + F.getSala().getSilla(posicionV, posicionH).getIncremento();
        if (cliente.getCuenta().getSaldo() >= precioBoleta) {
            Boleta boleta = new Boleta(cliente.getCuenta(), F, F.getSala().getSilla(posicionV, posicionH));
            Data.writeTxt("boletas.txt", Boleta.getBoletasList());
            int saldo_nuevo = cliente.getCuenta().getSaldo() - precioBoleta;
            cliente.getCuenta().setSaldo(saldo_nuevo);
            Data.writeTxt("cuentas.txt", Cuenta.getCuentasList());
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
