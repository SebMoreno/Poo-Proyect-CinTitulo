package baseDeDatos;

import gestorAplicacion.cine.Boleta;
import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Pelicula;
import gestorAplicacion.cine.Sala;
import gestorAplicacion.cine.Silla;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.Invitado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import uiMain.*;
import gestorAplicacion.usuario.Usuario;

public class Registro {

    final static public HashMap<String, OpcionDeMenu> menu_generico = new HashMap<>();
    public final HashMap<Usuario, MenuDeConsola> menus_usarios = new HashMap<>();
    public static void initConfig(){
    readAllTxt();
    god_menu_birth();
    Main.usuarioActivo = new Invitado();
    }

    static private void readAllTxt() {
        Usuario.RT();
        Cuenta.RT();
        Silla.RT();
        Sala.RT();
        Pelicula.RT();
        Funcion.RT();
        Boleta.RT();
    }

    static private void god_menu_birth() {
        menu_generico.put("iniciar sesion", new IniciarSesion("Log In"));
        menu_generico.put("cerrar sesion", new CerrarSesion("Log Out"));
        menu_generico.put("informacion pelicula", new Informacionpelicula("Informacion Peliculas"));
        menu_generico.put("comprar pelicula", new ComprarBoleta("Comprar Boleta"));
        menu_generico.put("reservar pelicula", new ReservarBoleta("Reservar Boleta"));
        menu_generico.put("ver informacion cuenta", new InformacionCuenta("Ver Informacion Cuenta"));
        menu_generico.put("actualizar saldo", new RecargarSaldo("Recargar Saldo"));
        menu_generico.put("registrarse", new RegistrarNuevoUsuario("Registrarse"));
        menu_generico.put("actualizar menu", new ActualizarMenu("Actualizar Menu"));
        menu_generico.put("editar pelicula", new EditarPelicula("Editar Pelicula"));
        menu_generico.put("iniciar como invitado", new IniciarComoInvitado("Iniciar Como Invitado"));
        menu_generico.put("salir", new Salir("Salir"));
    }

    public static void writeTxt(String archivo, HashMap<String, String[]> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/temp/" + archivo));) {
            for (Map.Entry<String, String[]> entry : lista.entrySet()) {
                bw.write(entry.getKey());
                for (String value : entry.getValue()) {
                    bw.write(" " + value);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");  // Por revisar y codificar
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }

    }

    public static void readTxt(String archivo, HashMap<String, String[]> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/temp/" + archivo));) {
            String line = br.readLine();

            while (line != null) {
                String[] datos = line.split(" ");
                String[] aux = new String[datos.length - 1];
                System.arraycopy(datos, 1, aux, 0, (datos.length - 1));
                lista.put(datos[0], aux);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");  // Por revisar y codificar
        }

    }
}
