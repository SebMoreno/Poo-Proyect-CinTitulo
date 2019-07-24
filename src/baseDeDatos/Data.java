package baseDeDatos;

import gestorAplicacion.cine.*;
import gestorAplicacion.usuario.*;
import uiMain.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Data {

    public static final HashMap<String, OpcionDeMenu> menu_generico = new HashMap<>();
    private static MenuDeConsola menuInicial;

    public static void initConfig() {
        readAllTxt();
        crearMenus();
        menuInicial.lanzarMenu();
    }

    static private void crearMenus() {
        god_menu_birth();
        menuInicial();
        menuAdmin();
        menuCliente();
        menuInvitado();
    }

    static private void god_menu_birth() {
        menu_generico.put("iniciar sesion", new IniciarSesion());
        menu_generico.put("informacion pelicula", new Informacionpelicula());
        menu_generico.put("comprar boleta", new ComprarBoleta());
        menu_generico.put("ver informacion cuenta", new InformacionCuenta("Ver Informacion Cuenta"));
        menu_generico.put("actualizar saldo", new RecargarSaldo("Recargar Saldo"));
        menu_generico.put("registrarse", new Registrarse());
        menu_generico.put("actualizar menu", new ActualizarMenu("Actualizar Menu"));
        menu_generico.put("editar pelicula", new EditarPelicula("Editar Pelicula"));
        menu_generico.put("iniciar como invitado", new IniciarComoInvitado("Iniciar Como Invitado"));
        menu_generico.put("terminar programa", new Salir());
        menu_generico.put("añadir pelicula", new AñadirPelicula());
        menu_generico.put("eliminar pelicula", new EliminarPelicula());
        menu_generico.put("crear funcion", new CrearFuncion());
        menu_generico.put("eliminar funcion", new EliminarFuncion());
        menu_generico.put("informacion funciones", new InformacionFunciones());
    }

    static private void menuInicial() {
        ArrayList<OpcionDeMenu> options = new ArrayList<>();
        options.add(menu_generico.get("iniciar sesion"));
        options.add(menu_generico.get("registrarse"));
        options.add(menu_generico.get("iniciar como invitado"));
        options.add(menu_generico.get("comprar boleta"));
        options.add(menu_generico.get("terminar programa"));
        menuInicial = new MenuDeConsola(options);
    }

    static private void menuAdmin() {
        ArrayList<OpcionDeMenu> options = new ArrayList<>();
        options.add(menu_generico.get("añadir pelicula"));
        options.add(menu_generico.get("eliminar pelicula"));
        options.add(menu_generico.get("crear funcion"));
        options.add(menu_generico.get("eliminar funcion"));
        options.add(menu_generico.get("terminar programa"));
        Administrador.setMenu(new MenuDeConsola(options));
    }

    static private void menuCliente() {

        ArrayList<OpcionDeMenu> options = new ArrayList<>();
        options.add(Data.menu_generico.get("informacion pelicula"));
        options.add(Data.menu_generico.get("informacion funciones"));
        options.add(Data.menu_generico.get("comprar pelicula"));
        options.add(Data.menu_generico.get("ver informacion cuenta"));
        options.add(Data.menu_generico.get("actualizar saldo"));
        options.add(Data.menu_generico.get("terminar programa"));
        Cliente.setMenu(new MenuDeConsola(options));

    }
    static private void menuInvitado(){
        ArrayList<OpcionDeMenu> options = new ArrayList<>();
        options.add(Data.menu_generico.get("registrarse"));
        options.add(Data.menu_generico.get("informacion pelicula"));
        options.add(Data.menu_generico.get("informacion funciones"));
        options.add(Data.menu_generico.get("terminar programa"));       
        Invitado.setMenu(new MenuDeConsola(options));
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
