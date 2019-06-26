package gestorAplicacion.usuario;

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
    String usuario(){
        return usuario;
    }
    String cargo(){
        return cargo;
    }
    
}
