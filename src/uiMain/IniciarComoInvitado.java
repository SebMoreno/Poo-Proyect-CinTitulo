
package uiMain;

public class IniciarComoInvitado extends OpcionDeMenu {
    private String titulomenu;
    
    IniciarComoInvitado(){
        MenuDeConsola.Añadir_opcion(this);
    }
    
    public void ejecutar(){
    }
    
    public String toString(){
        return titulomenu;
    }
}  
