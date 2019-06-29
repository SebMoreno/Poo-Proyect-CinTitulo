package uiMain;

import java.util.*;

public class Informacionpelicula extends OpcionDeMenu {

    Scanner entrada = new Scanner(System.in);
    private String descripcion;
    
    Informacionpelicula(String s){
        this.descripcion=s;
    }
    
    @Override
    public void ejecutar() {
        
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
