package uiMain;

import java.util.Scanner;
import java.util.ArrayList;
public class IniciarSesion extends OpcionDeMenu {
    private String titulomenu;
    private static String usuarioActivo;
    Scanner scan = new Scanner(System.in);
    
    
    public IniciarSesion(String s){
        this.titulomenu = s;
    }
    
    public void ejecutar(){
        System.out.println("Ingrese usuario");
        String nickname = scan.next();
        System.out.println("Ingrese contraseña");
        String pass = scan.next();
        
        while(!gestorAplicacion.usuario.Usuario.getUsersList().containsKey(nickname)){
            
        System.out.println("Usuario invalido");
        System.out.println("Ingrese nuevamente usuario");
        nickname = scan.next();
        }
        usuarioActivo=nickname;
        String aux []=gestorAplicacion.usuario.Usuario.getUsersList().get(nickname);
        String contraseña = aux[0];
        
       while(contraseña != pass){
           System.out.println("Contraseña invalida");
           System.out.println("Ingrese nuevamente la contraseña");
           pass = scan.next();
       
          }
       //falta resto del codigo para el menu
        
        
         }
   
    
    public static String getUsuarioActivo() {
        
        
        return usuarioActivo;
    }
    
    
    
    
    public String toString(){
        return titulomenu;
    }
}
    
    
 
