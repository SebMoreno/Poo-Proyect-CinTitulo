
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
                System.out.println("genero: " + entry.getValue()[0] + "         " + "clasificación: " + entry.getValue()[1]);
                System.out.println("duración: " + entry.getValue()[2] + "           " + "idioma: " + entry.getValue()[3]);
            }

    }
    @Override
    public String toString() {
        return info;
    }
}
