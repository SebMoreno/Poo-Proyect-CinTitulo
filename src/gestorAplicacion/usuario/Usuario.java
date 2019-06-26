package gestorAplicacion.usuario;

import java.util.*;

public class Usuario {//esta sera mi super clase por eso tiene todo lo que puede hacer un usuario

    private final String usuario;
    private final String rol;
    private final Cuenta cuenta;
    private String clave;
    private String nombre;
    private String email;
    private static HashMap<String, String[]> usersList = new HashMap<>();

    static {
        baseDeDatos.RegistroUsuario.readTxt();

    }

    public Usuario(String usuario, String clave, String rol) {
        this(usuario, clave, rol, "NN");
    }

    protected Usuario(String usuario, String clave, String rol, String nombre) {
        this(usuario, clave, rol, nombre, "NE");
    }

    protected Usuario(String usuario, String clave, String rol, String nombre, String email) {
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.nombre = nombre;
        this.email = email;
        this.cuenta = new Cuenta(this);
        if (!usersList.containsKey(usuario)) {
            String[] aux = {clave, rol, nombre, email};
            usersList.put(usuario, aux);
            baseDeDatos.RegistroUsuario.writeTxt();
        } else {
            System.out.println("usuario ya usado");
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRol() {
        return rol;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static HashMap<String, String[]> getUsersList() {
        return usersList;
    }

}
