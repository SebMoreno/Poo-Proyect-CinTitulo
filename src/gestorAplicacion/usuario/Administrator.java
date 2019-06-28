package gestorAplicacion.usuario;
import gestorAplicacion.cine.Funcion;

public class Administrator {
    private long cedula;
    private String nombre;
    private int telefono;
    private String email;
    private String usuario;
    private String cargo;
    
    long get_cc(){
      return cedula;  
    }
    String get_nombre(){
    return nombre;
    }
    int get_telefono(){
        return telefono;
    }
    String get_email(){
        return email;
    }
    String get_usuario(){
        return usuario;
    }
    String get_cargo(){
        return cargo;
    }
    void set_cc(long cedula){
        this.cedula=cedula;
    }
    void set_nombre(String nombre){
        this.nombre=nombre;
    }
    void set_telefono(int telefono){
        this.telefono=telefono;
    }
    void set_email(String email){
        this.email=email;
    }
    void set_cargo(String cargo){
        this.cargo=cargo;
    }
}
