package uiMain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ReservarBoleta extends OpcionDeMenu {
    private String titulomenu;
    private ArrayList<String> funciones = new ArrayList<String>();
    private ArrayList<String> peliculas = new ArrayList<String>();
    
    public ReservarBoleta(String s){
        this.titulomenu = s;
    }
    
    public void ejecutar(){
        //La maricada de las sillas c:
    }
    
    public String toString(){
        return titulomenu;
    }
} 
    

