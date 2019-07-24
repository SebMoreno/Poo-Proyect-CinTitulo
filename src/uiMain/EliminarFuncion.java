package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.cine.Funcion;
import java.util.Scanner;

public class EliminarFuncion extends OpcionDeMenu {

    private String titulomenu = "Eliminar Funcion";
    
    @Override
    public void ejecutar() {
        Scanner esc = new Scanner(System.in);
        System.out.println("//////////////////Lista de las funciones//////////////////");
        InformacionFunciones.imprimirFunciones();
        System.out.println("Ingrese SOLO el numero de la funcion a eliminar");        
        String idFuncion = esc.next();
        gestorAplicacion.cine.Pelicula.getPelisList().remove(idFuncion);
        Data.writeTxt("funciones.txt", Funcion.getFuncionesList());
        System.out.println("¡Funcion eliminada con exito!");
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}
