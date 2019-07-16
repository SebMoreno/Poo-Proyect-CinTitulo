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
    HashMap <String, OpcionDeMenu> menu_generico = new HashMap <>(); //falta añadir cada opcion existente de los menus
    public HashMap <Usuario, MenuDeConsola> menus_usarios = new HashMap <>();
    public void MenuString_to_MenuOptions(String [] menu_user_string, ArrayList<OpcionDeMenu> menu_user){
        for (String i : menu_user_string){
            menu_user.add(menu_generico.get(i));
        }
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
