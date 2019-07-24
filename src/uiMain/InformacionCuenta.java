
package uiMain;
import java.util.*;
public class InformacionCuenta extends OpcionDeMenu {
    private String info;
    
    public InformacionCuenta(String s){
        this.info=s;
    }
    @Override
    public void ejecutar() {

        for (Map.Entry<String, String[]> entry : gestorAplicacion.usuario.Usuario.getUsersList().entrySet()) {
                System.out.println("            " + entry.getKey() + "          ");
                System.out.println("Usuario: " + entry.getValue()[0] + "         " + "clave: " + entry.getValue()[1]);
                System.out.println("rol: " + entry.getValue()[2] + "           " + "nombre: " + entry.getValue()[3]);
                System.out.println("e-mail: " + entry.getValue()[4]);
            }

    }
    @Override
    public String toString() {
        return info;
    }
}
