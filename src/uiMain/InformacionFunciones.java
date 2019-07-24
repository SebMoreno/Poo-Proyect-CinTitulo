package uiMain;

import gestorAplicacion.cine.Funcion;
import java.util.Map;



public class InformacionFunciones extends OpcionDeMenu {
    private final String titulomenu = "Mostrar listado de funciones";

    @Override
    public String toString() {
        return titulomenu;
    }

    @Override
    public void ejecutar() {
        imprimirFunciones();
    }
    private void imprimirFunciones() {
    for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Funcion.getFuncionesList().entrySet()) {
                System.out.println("****" + "Funcion " + entry.getKey() + " ****");
                System.out.println("Sala: " + entry.getValue()[0]);
                System.out.println("Titulo pelicula: " + entry.getValue()[1]);
                System.out.println("Hora: " + entry.getValue()[2]);
                System.out.println("Sillas ocupadas: " + entry.getValue()[3]);
            }
        }
    }

