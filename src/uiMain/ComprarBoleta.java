package uiMain;

import gestorAplicacion.cine.Boleta;
import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Sala;
import gestorAplicacion.usuario.Cliente;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ComprarBoleta extends OpcionDeMenu {

    private String titulomenu;
    private String titulopelicula;
    private ArrayList<String> funciones = new ArrayList<String>();
    private ArrayList<String> peliculas = new ArrayList<String>();

    @Override
    public void ejecutar() {
        System.out.println("Escoja una pelicula\nEscribe el titulo de la pelicula exactamente como aparece");
        imprimirPeliculas();
        Scanner entrada = new Scanner(System.in);
        String titulo = entrada.next();
        System.out.println("Seleccione el numero de la funcion deseada");
        for (Map.Entry<String, String[]> entry : Funcion.getFuncionesList().entrySet()) {
            if ((entry.getValue()[1]).equals(titulo)) {
                System.out.println("************" + "Funcion " + entry.getKey() + " ************");
                System.out.println("Sala: " + entry.getValue()[0]);
                System.out.println("Titulo pelicula: " + entry.getValue()[1]);
                System.out.println("Hora: " + entry.getValue()[2]);
                System.out.println("Sillas ocupadas: " + entry.getValue()[3]);
            }
        }
        System.out.println("Escoja una funcion\nEscribe el numero de la funcion");
        String funcion = entrada.next();
        Funcion F = new Funcion(funcion);
        Sala sala = new Sala(Funcion.getFuncionesList().get(funcion)[0]);
        System.out.println(sala);
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
        int precioBoleta = sala.getPrecio() + sala.getSilla(posicionV, posicionH).getIncremento();
        if (cliente.getCuenta().getSaldo() >= precioBoleta) {
            Boleta boleta = new Boleta(cliente.getCuenta(), F, sala.getSilla(posicionV, posicionH));
            System.out.println("Su compra fue realizada con éxito");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public String toString() {
        return titulomenu;
    }

    private void imprimirPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
