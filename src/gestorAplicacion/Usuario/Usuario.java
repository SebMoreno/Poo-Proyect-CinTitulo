package gestorAplicacion.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Usuario {//esta sera mi super clase por eso tiene todo lo que puede hacer un usuario

    private final String usuario;
    private final String rol;
    private String nombre;
    private String email;
    private String clave;
    private int saldo;
    private static HashMap<String, String[]> usersList = new HashMap<>();

    static {
        readTxt();
    }

    public Usuario(String usuario, String clave, String rol) {
        this.usuario = usuario;
        this.rol = rol;
        if (!usersList.containsKey(usuario)) {
            this.clave = clave;
            String[] aux = {clave, rol};
            usersList.put(usuario, aux);
            writeTxt();
        } else {
            System.out.println("usuario ya usado");
        }

    }

    protected Usuario(String usuario, String clave, String rol, String nombre) {
        this(usuario, clave, rol);
        this.nombre = nombre;
    }

    protected Usuario(String usuario, String clave, String rol, String nombre, String email) {
        this(usuario, clave, rol, nombre);
        this.email = email;
    }

    protected Usuario(String usuario, String clave, String rol, String nombre, String email, int saldo) {
        this(usuario, clave, rol, nombre, email);
        this.saldo = saldo;
    }//lo que el usuario registrado debe tener

    public void writeTxt() {
        Scanner scan = new Scanner(System.in);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../../temp/fichero1.txt"));) {
            for (Map.Entry<String, String[]> entry : usersList.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1]);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");
        }

    }

    public static void readTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader("../../temp/fichero1.txt"));) {
            String line;
            do {
                line = br.readLine();
                String[] datos = line.split(" ");
                String[] aux = {datos[1], datos[2]};
                usersList.put(datos[0], aux);
            } while (line != null);
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");
        }

    }

    public String getnombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
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
/*System.out.println("Ingrese nombre");
        nombre = entrada.next();
        System.out.println("Ingrese usuario");
        usuario = entrada.next();
        System.out.println("Ingrese email");
        email = entrada.next();
        System.out.println("Ingrese clave");
        clave = entrada.next();
        System.out.println("Ingrese saldo");
        saldo = entrada.nextInt();
     */
    public static String crearUsuario(String nombre, String usuario, String email, String clave, int saldo) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:/Users/Usuario/Desktop/fichero1.txt"));) {
            bw.write("hola hermoso");
            bw.flush();
        } catch (IOException e) {
            System.out.println("error al agregar usuario");
        }
        return "Registro exitoso";

    }

    //para registrar usuario necesito base de datos
    //para modificar tambien hay que hacerlo en la base de datos
}
