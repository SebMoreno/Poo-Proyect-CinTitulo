package uiMain;

public class IniciarSesion extends OpcionDeMenu {
    private String titulomenu;
    
    IniciarSesion(){
        MenuDeConsola.Añadir_opcion(this);
    }
    
    public void ejecutar(){
        //terminar método 
    }
    
    public String toString(){
        return titulomenu;
    }
} 
