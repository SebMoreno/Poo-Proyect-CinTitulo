package uiMain;
import baseDeDatos.Data;
import gestorAplicacion.usuario.Invitado;
import java.util.ArrayList;
import java.util.Scanner;

public class IniciarComoInvitado extends OpcionDeMenu {
    private String titulomenu;
    String [] array_s = {"informacion pelicula","registrarse"};
    public ArrayList <OpcionDeMenu> array_o = new ArrayList <> ();
    MenuDeConsola menu_guest = new MenuDeConsola(array_o);
    Scanner input = new Scanner(System.in);
    
    public IniciarComoInvitado(String s){
        titulomenu=s;
        menu_guest.opciones.add(Data.menu_generico.get("informacion pelicula"));
        menu_guest.opciones.add(Data.menu_generico.get("registrarse"));
    }
    
    @Override
    public void ejecutar() {
        Main.menu = Invitado.getMenu();
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}
