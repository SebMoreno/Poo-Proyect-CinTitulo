package baseDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RegistroUsuario extends Registro{

    @Override
    public void writeTxt() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/temp/usuarios.txt"));) {
            for (Map.Entry<String, String[]> entry : gestorAplicacion.usuario.Usuario.getUsersList().entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1] + " " + entry.getValue()[2]+ " " + entry.getValue()[3] + " " + entry.getValue()[4]);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");
        }

    }

    @Override
    public void readTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/temp/usuarios.txt"));) {
            String line;
            do {
                line = br.readLine();
                String[] datos = line.split(" ");
                String[] aux = {datos[1], datos[2], datos[3], datos[4], datos[5]};
                gestorAplicacion.usuario.Usuario.getUsersList().put(datos[0], aux);
            } while (line != null);
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");
        }

    }
}
