package uiMain;

public class CerrarSesion extends OpcionDeMenu {
    private String titulomenu;
    
    public CerrarSesion (String s){
        this.titulomenu = s;
    }
    
    @Override
    public void ejecutar (){
    }
    
    public String toString(){
        return titulomenu;
    }
} 
