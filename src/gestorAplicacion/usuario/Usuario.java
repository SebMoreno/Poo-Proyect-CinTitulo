package gestorAplicacion.usuario;

import baseDeDatos.Registro;
import static baseDeDatos.Registro.readTxt;
import static baseDeDatos.Registro.writeTxt;
import java.util.HashMap;
import java.util.ArrayList;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import java.util.Scanner;

public abstract class Usuario {//esta sera mi super clase por eso tiene todo lo que puede hacer un usuario

    private Scanner scan = new Scanner(System.in);
    private final String usuario;
    private final String rol;
    private final Cuenta cuenta;
    private String clave;
    private String nombre;
    private String email;
    private static HashMap<String, String[]> usersList = new HashMap<>(); // key: usuario    value: clave, rol, nombre, email
    public ArrayList <OpcionDeMenu> menu_user = new ArrayList <> ();
    public MenuDeConsola console_menu_user = new MenuDeConsola(menu_user);
    
    static {
        readTxt("usuarios.txt", usersList);
    }

    protected Usuario(String usuario, String clave, String rol, String nombre, String email) {
        this.clave = clave;
        this.rol = rol;
        this.nombre = nombre;
        this.email = email;
        while (usersList.containsKey(usuario)) {
            System.out.println("usuario ya usado\nIngrese un nombre de usuario nuevo");
            usuario = scan.next();
        }
        String[] aux = {clave, rol, nombre, email};
        usersList.put(usuario, aux);
        writeTxt("usuarios.txt", usersList);
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
