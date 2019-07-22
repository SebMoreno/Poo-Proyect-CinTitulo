package uiMain;
import baseDeDatos.Registro;
import static baseDeDatos.Registro.MenuString_to_MenuOptions;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.usuario.*;
public class Main {
    public static void main(String[] args) {
        Registro.god_menu_birth();
        Scanner scan = new Scanner(System.in);
        ArrayList <OpcionDeMenu> menu_1 = new ArrayList<>();
        menu_1.add(Registro.menu_generico.get("iniciar sesion"));
        menu_1.add(Registro.menu_generico.get("iniciar como invitado"));
        menu_1.add(Registro.menu_generico.get("salir"));
        MenuDeConsola menu_inicial = new MenuDeConsola(menu_1);
        menu_inicial.lanzarMenu();
        int option = scan.nextInt();
        menu_1.get(option-1).ejecutar();
        /*while(!option.equals("3"))
        if (option.equals("1")){
            String nickname = scan.next();
            String pass = scan.next();
            //codigo para verificar si es cliente o admin y para desplegar los respectivos menús
            break; //por ahora, cuando se implemente el codigo se quitará el break
        }
        else if (option.equals("2")){
            Invitado guest = new Invitado(Invitado.numero_invitados);
            guest.console_menu_user.lanzarMenu();
        }
                */
    }
    
    
    
}
