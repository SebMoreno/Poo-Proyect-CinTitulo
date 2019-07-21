package uiMain;

public class ActualizarMenu extends OpcionDeMenu{
    private String titulomenu;
    
    public ActualizarMenu(String s){
        titulomenu=s;
    }
    
    @Override
    public void ejecutar() {
        
    }

    @Override
    public String toString() {
        return titulomenu;
    }
    
}
