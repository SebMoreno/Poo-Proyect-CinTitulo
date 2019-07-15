package uiMain;

public class Salir extends OpcionDeMenu {
    private String titulomenu;
    
    Salir(){
        MenuDeConsola.Añadir_opcion(this);
    }
    
    public void ejecutar(){
        //terminar método 
    }
    
    public String toString(){
        return titulomenu;
    }
}
    

