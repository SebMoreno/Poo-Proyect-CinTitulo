package uiMain;

import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Pelicula;
import gestorAplicacion.cine.Sala;
import java.util.Map;
import java.util.Scanner;
//opcion de menu para crearfunciones (es unica de administrador)
public class CrearFuncion extends OpcionDeMenu{
    
    private String titulomenu = "Crear Funcion";
    Scanner input = new Scanner(System.in);
    @Override
    public void ejecutar() {//metodo abstracto ejecutar
        Informacionpelicula.imprimirPeliculas();//mirar descripcion en la clase informacion pelicula
        for(Map.Entry<String, String[]> entry : gestorAplicacion.cine.Sala.getSalasList().entrySet()){//escoja la sala para la funcion
            System.out.println("******** ID: " + entry.getKey() + " ********");
            System.out.println("Precio: " + entry.getValue()[0]);
            System.out.println("Tipo:   " + entry.getValue()[1]);
            System.out.println("Capacidad:  " + entry.getValue()[2]);
        }
        System.out.print("Ingrese el ID de una sala: ");
        String ID = input.next();
        Sala sala = new Sala(ID);
        System.out.print("Ingrese una hora para la función: ");
        String hora = input.next();
        System.out.print("Ingrese una película para reproducir en la función: ");
        String pelicula = input.next();
        Pelicula peli = new Pelicula(pelicula);//los constructores se encargan de crear eso
        
        Funcion funcion = new Funcion(sala,hora,peli);
        System.out.println("¡La Función ha sido agregada con exito!");
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}

