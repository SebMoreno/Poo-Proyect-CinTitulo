package uiMain;
import java.util.*;

public class ComprarBoleta extends OpcionDeMenu {
    private String titulomenu;
    private String titulopelicula;
    
    public ComprarBoleta(String s){
        this.titulomenu = s;
        
    }
    
    public void ejecutar(){
        String sala = gestorAplicacion.cine.Pelicula.getPelisList().get(titulopelicula)[4];
        String precio = gestorAplicacion.cine.Sala.getSalasList().get(sala) [0];
        System.out.println("El precio de la pelicula es "+precio);
        String nombre =uiMain.IniciarSesion.getUsuarioActivo();
        String saldouser= gestorAplicacion.usuario.Cuenta.getCuentasList().get(nombre) [0];
        int precioentero = Integer.parseInt(precio);
        int saldouserentero = Integer.parseInt(saldouser);
        
        if (precioentero > saldouserentero){
            System.out.println("saldo insuficiente");
            
        }
        
        else{
           System.out.println("Escoja silla"); 
           
           
           
        }
    }
    
    public String toString(){
        return titulomenu;
    }
}
