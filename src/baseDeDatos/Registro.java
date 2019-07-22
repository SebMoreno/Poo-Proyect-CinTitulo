package baseDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import uiMain.*;
import gestorAplicacion.usuario.Usuario;


   

public class Registro {
    static public HashMap <String, OpcionDeMenu> menu_generico = new HashMap <>(); //falta añadir cada opcion existente de los menus
    public HashMap <Usuario, MenuDeConsola> menus_usarios = new HashMap <>();
    
    static public ArrayList<OpcionDeMenu> MenuString_to_MenuOptions(String [] menu_user_string){
        ArrayList <OpcionDeMenu> aux = new ArrayList<>();
        for (String i : menu_user_string){
            aux.add(menu_generico.get(i));
        }
        return aux;
    }
    
    static public void god_menu_birth(){
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
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");  // Por revisar y codificar
        }

    }

    public static void readTxt(String archivo, HashMap<String, String[]> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/temp/" + archivo));) {
            String line;
            do {
                line = br.readLine();
                String[] datos = line.split(" ");

                String[] aux = new String[datos.length - 1];
                System.arraycopy(datos, 1, aux, 0, (datos.length - 1));
                lista.put(datos[0], aux);
            } while (line != null);
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");  // Por revisar y codificar
        }

    }
}
