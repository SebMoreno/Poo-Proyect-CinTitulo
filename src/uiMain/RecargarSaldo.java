package uiMain;
import baseDeDatos.Data;
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
        String user = Main.usuarioActivo.getUsuario();
        System.out.println("Ingrese Saldo A Recargar");
        int saldo_plus = scan.nextInt();
        while(saldo_plus<=0){
            System.out.println("Ingrese Saldo válido");
            saldo_plus = scan.nextInt();
        }
        String [] aux = gestorAplicacion.usuario.Cuenta.getCuentasList().get(user);
        aux[0] = Integer.toString(Integer.valueOf(aux[0]) + saldo_plus);
        gestorAplicacion.usuario.Cuenta.getCuentasList().put(user,aux);
        Data.writeTxt("Cuenta.txt", gestorAplicacion.usuario.Cuenta.getCuentasList());
    }
    
    public String toString(){
        return titulomenu;
    }
} 
