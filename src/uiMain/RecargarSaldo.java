package uiMain;
import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;
import java.util.Scanner;

public class RecargarSaldo extends OpcionDeMenu {
   /* static {
        readTxt("cuentas.txt", gestorAplicacion.usuario.Cuenta.getCuentasList());
    } */
    private String titulomenu;
    Scanner scan = new Scanner(System.in);
    public RecargarSaldo (String s){
        this.titulomenu = s;
    }
    
    public void ejecutar(){
    /*    
    String nombre =uiMain.IniciarSesion.getUsuarioActivo();
    System.out.println("Ingrese su recarga");
    int recarga= scan.nextInt();
    while(recarga<=0){
        System.out.println("Ingrese un valor valido para su recarga, impedido");
        recarga=scan.nextInt();
    }
    int original= Integer.parseInt(gestorAplicacion.usuario.Cuenta.getCuentasList().get(nombre) [0]);
    
    String Recarga = Integer.toString(recarga+original);
    gestorAplicacion.usuario.Cuenta.getCuentasList().get(nombre) [0] = Recarga;
    System.out.println("Recarga exitosa");
    writeTxt("cuentas.txt", gestorAplicacion.usuario.Cuenta.getCuentasList());
    
    
    
      */  
    }
    
    public String toString(){
        return titulomenu;
    }
} 
