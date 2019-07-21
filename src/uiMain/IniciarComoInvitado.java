package uiMain;

public class IniciarComoInvitado extends OpcionDeMenu {
    private String titulomenu;
    
    public IniciarComoInvitado(String s){
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
