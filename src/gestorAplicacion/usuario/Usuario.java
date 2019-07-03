package gestorAplicacion.usuario;

import java.util.HashMap;

public class Usuario {//esta sera mi super clase por eso tiene todo lo que puede hacer un usuario

    private final String usuario;
    private final String rol;
    private final Cuenta cuenta;
    private String clave;
    private String nombre;
    private String email;
    private static HashMap<String, String[]> usersList = new HashMap<>(); // key: usuario    value: clave, rol, nombre, email

    public Usuario(String usuario, String clave, String rol) {
        this(usuario, clave, rol, "NN");
    }

    public Usuario(String usuario, String clave, String rol, String nombre) {
        this(usuario, clave, rol, nombre, "NE");
    }

    public Usuario(String usuario, String clave, String rol, String nombre, String email) {
        this.clave = clave;
        this.rol = rol;
        this.nombre = nombre;
        this.email = email;
        baseDeDatos.Registro r = new baseDeDatos.RegistroUsuario();
        r.readTxt();
        while (usersList.containsKey(usuario)) {
            System.out.println("usuario ya usado");//Programar para mostrar error y perdir nuevo usuario
            //this.usuario = nueva entrada del usuario
        }
        String[] aux = {clave, rol, nombre, email};
        usersList.put(usuario, aux);
        r.writeTxt();
        this.usuario = usuario; // Quitar esta linea al acabar con while del menu
        this.cuenta = new Cuenta(this);
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
