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
        Informacionpelicula.imprimirPeliculas();
        System.out.print("Escoja una pelicula\nEscribe el titulo de la pelicula exactamente como aparece: ");
        Scanner entrada = new Scanner(System.in);
        String titulo = entrada.next();
        int i = 0;
        for (Map.Entry<String, String[]> entry : Funcion.getFuncionesList().entrySet()) {
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
        System.out.print("Ingrese la coordenada vertical: ");
        int posicionV = entrada.nextInt();
        System.out.print("Ingrese la coordenada horizontal: ");
        int posicionH = entrada.nextInt();
        while (F.getSala().getSilla(posicionV, posicionH).isOcupada()) {
            System.out.println("La silla está ocupada, Intente otra por favor");
            System.out.print("Ingrese la coordenada vertical: ");
            posicionV = entrada.nextInt();
            System.out.print("Ingrese la coordenada horizontal: ");
            posicionH = entrada.nextInt();
        }

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
