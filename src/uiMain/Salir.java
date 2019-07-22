package uiMain;

public class Salir extends OpcionDeMenu {
    private String titulomenu;
    
    public Salir(String s){
        titulomenu=s;
    }
    
    public void ejecutar(){
        Main.navegador--;
    }
    
    public String toString(){
        return titulomenu;
    }
}
    

