package baseDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RegistroBoletas {
    private static File file;
    public static void nuevaBoletasList(int nombreFile){
        file = new File("src/temp/boletas", "b" + Integer.toString(nombreFile) + ".txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("error de lectura de archivo");// Por revisar y codificar
        }
    
    }

    public static void writeTxt() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()));) {
            for (Map.Entry<String, Integer[]> entry : gestorAplicacion.usuario.Cuenta.getCuentasList().entrySet()) {
                bw.write(entry.getKey() + " " + Integer.toString(entry.getValue()[0]) + " " + Integer.toString(entry.getValue()[1]));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");// Por revisar y codificar
        }

    }

    public void readTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()));) {
            String line;
            
            do {
                line = br.readLine();
                String[] datos = line.split(" ");
                Integer[] aux = {Integer.parseInt(datos[1]), Integer.parseInt(datos[2])};
                
                //gestorAplicacion.usuario.Cuenta.getBoletasList().put(datos[0], aux);
            } while (line != null);
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");// Por revisar y codificar
        }

    }
}
