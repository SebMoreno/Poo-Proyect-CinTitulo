
package uiMain;
import java.util.*;
public class InformacionCuenta extends OpcionDeMenu {
    private String info;
    
    public InformacionCuenta(String s){
        this.info=s;
    }
    @Override
    public void ejecutar() {
        String nick = Main.usuarioActivo.getUsuario();
        System.out.println("            " + Main.usuarioActivo.getNombre() + "          ");
        System.out.println("Usuario: " + nick + "         " + "Saldo: " + gestorAplicacion.usuario.Cuenta.getCuentasList().get(nick)[0]);
        for (int i=1; i<gestorAplicacion.usuario.Cuenta.getCuentasList().get(nick).length; i++){
            System.out.println("Boleta con ID: " + gestorAplicacion.usuario.Cuenta.getCuentasList().get(nick)[i]);
        }

    }
    @Override
    public String toString() {
        return info;
    }
}
