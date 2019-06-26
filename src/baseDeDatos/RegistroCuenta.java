package baseDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RegistroCuenta {

    public static void writeTxt() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../../temp/cuentas.txt"));) {
            for (Map.Entry<String, String[]> entry : gestorAplicacion.usuario.Cuenta.getCuentasList().entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1]);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");
        }

    }

    public static void readTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader("../../temp/cuentas.txt"));) {
            String line;
            do {
                line = br.readLine();
                String[] datos = line.split(" ");
                String[] aux = {datos[1], datos[2]};
                gestorAplicacion.usuario.Cuenta.getCuentasList().put(datos[0], aux);
            } while (line != null);
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");
        }

    }

}
