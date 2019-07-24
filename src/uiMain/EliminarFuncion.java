package uiMain;

import baseDeDatos.Data;
import gestorAplicacion.cine.Funcion;
import java.util.Scanner;
//opcion de menu para eliminarfuncion (es unica de administrador)
public class EliminarFuncion extends OpcionDeMenu {

    private String titulomenu = "Eliminar Funcion";
    
    @Override
    public void ejecutar() {//elimina la funcion del hash he invoca al write para escribir nuevamente en el txt
        Scanner esc = new Scanner(System.in);
        InformacionFunciones.imprimirFunciones();
        System.out.println("Ingrese SOLO el numero de la funcion a eliminar");        
        String idFuncion = esc.next();
        gestorAplicacion.cine.Funcion.getFuncionesList().remove(idFuncion);
        Data.writeTxt("funciones.txt", Funcion.getFuncionesList());
        System.out.println("¡Funcion eliminada con exito!");
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}
