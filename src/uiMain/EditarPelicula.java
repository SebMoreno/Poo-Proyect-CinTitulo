package uiMain;

public class EditarPelicula extends OpcionDeMenu{
    private String titulomenu;
    
    public EditarPelicula(String s){
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
