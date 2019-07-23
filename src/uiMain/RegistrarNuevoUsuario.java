 package uiMain;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Usuario;
import gestorAplicacion.usuario.Administrator;
import java.util.Scanner;
public class RegistrarNuevoUsuario extends OpcionDeMenu {
    private String titulomenu;
    Scanner scan = new Scanner(System.in);
    
    public RegistrarNuevoUsuario (String s){
        titulomenu=s;
    }
    
    public void ejecutar(){
    
        System.out.println("Ingrese un usuario");
        String usuario = scan.next();
        System.out.println("Ingrese una contraseña");
        String password = scan.next();
        System.out.println("Ingrese su rol(\"cliente\" o \"admin\")");
        String rol = scan.next();
        while((4%2)==0){
        if (rol.equals("cliente")||rol.equals("admin")){
            break;
            }
        else{
            System.out.println("Ingrese su rol(\"cliente\" o \"admin\")");
            rol = scan.next();
        }
        }
        System.out.println("Ingrese su email");
        String email=scan.next();
        System.out.println("Ingrese su nombre");
        String nombre=scan.next();
        if(rol.equals("cliente")){
            Cliente nuevo = new Cliente(usuario,password,nombre,email,false) ;    
        }
        else{
            //crear txt con un codigo
            Administrator nuevo = new Administrator(usuario,password,nombre,email,false);
        }
        
        
    }
    
@Override    
    public String toString(){
        return titulomenu; 
}    
    
}
