package uiMain;

public class CerrarSesion extends OpcionDeMenu {
    private String titulomenu;
    
    public void ejecutar(){
        MenuDeConsola.lanzarMenu();
    }
    
    public String toString(){
        return titulomenu;
    }
} 
