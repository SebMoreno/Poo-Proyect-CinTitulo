package uiMain;
import baseDeDatos.Registro;
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
        array_o = Registro.MenuString_to_MenuOptions(array_s);
        menu_guest.opciones = array_o;
    }
    
    @Override
    public void ejecutar() {
        menu_guest.lanzarMenu();
        int option = input.nextInt();
        array_o.get(option-1).ejecutar();
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}
