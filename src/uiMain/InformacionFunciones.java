package uiMain;

import java.util.Map;
//opcion informacion funciones disponible para todos los usuarios
public class InformacionFunciones extends OpcionDeMenu {

    private final String titulomenu = "Mostrar listado de funciones";

    @Override
    public String toString() {
        return titulomenu;
    }

    @Override
    public void ejecutar() {//accede al hash he imprime todas las keys y values(recordar que los values de nuestros hash map son arreglos)
        imprimirFunciones();
    }

    static void imprimirFunciones() {//metodo interesante , lo que esa es imprimir las funciones
        System.out.println("//////////////////Lista de las funciones//////////////////");
        if (!gestorAplicacion.cine.Funcion.getFuncionesList().isEmpty()) {
            for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Funcion.getFuncionesList().entrySet()) {
                System.out.println("************" + "Funcion " + entry.getKey() + "************");
                System.out.println("Sala: " + entry.getValue()[0]);
                System.out.println("Titulo pelicula: " + entry.getValue()[1]);
                System.out.println("Hora: " + entry.getValue()[2]);
                System.out.println("Sillas ocupadas: " + entry.getValue()[3]);
            }
        } else {
            System.out.println("No hay funciones ahora mismo");
        }
    }
}
