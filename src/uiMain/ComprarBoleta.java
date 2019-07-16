package uiMain;

public class ComprarBoleta extends OpcionDeMenu {
    private String titulomenu;
    
    public ComprarBoleta(String s){
        this.titulomenu = s;
    }
    
    public void ejecutar(){
        //terminar método cuando se estructure el sistema de pagos
    }
    
    public String toString(){
        return titulomenu;
    }
}
