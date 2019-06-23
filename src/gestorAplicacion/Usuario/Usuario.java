package gestorAplicacion.Usuario;

import java.io.Serializable;
import java.util.*;

public class Usuario implements Serializable {//esta sera mi super clase por eso tiene todo lo que puede hacer un usuario

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String usuario;
    private String email;
    private String clave;
    private int saldo;

    static Scanner entrada = new Scanner(System.in);

    protected Usuario() { //constructor por defecto
    }

    protected Usuario(String nombre, String usuario, String email, String clave, int saldo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.clave = clave;
        this.saldo = saldo;
    }//lo que el usuario registrado debe tener

    public String getnombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    //metodos para acceder a las variables privadas

    public static String crearUsuario(String nombre, String usuario, String email, String clave, int saldo) {
        System.out.println("Ingrese nombre");
        nombre = entrada.next();
        System.out.println("Ingrese usuario");
        usuario = entrada.next();
        System.out.println("Ingrese email");
        email = entrada.next();
        System.out.println("Ingrese clave");
        clave = entrada.next();
        System.out.println("Ingrese saldo");
        saldo = entrada.nextInt();

        return "Registro exitoso";

    }

    //para registrar usuario necesito base de datos
    //para modificar tambien hay que hacerlo en la base de datos
}
