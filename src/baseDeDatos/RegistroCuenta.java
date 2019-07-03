package baseDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RegistroCuenta extends Registro{

    @Override
    public void writeTxt() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/temp/cuentas.txt"));) {
            for (Map.Entry<String, Integer[]> entry : gestorAplicacion.usuario.Cuenta.getCuentasList().entrySet()) {
                bw.write(entry.getKey() + " " + Integer.toString(entry.getValue()[0]) + " " + Integer.toString(entry.getValue()[1]));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");// Por revisar y codificar
        }

    }

    @Override
    public void readTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/temp/cuentas.txt"));) {
            String line;
            do {
                line = br.readLine();
                String[] datos = line.split(" ");
                Integer[] aux = {Integer.parseInt(datos[1]), Integer.parseInt(datos[2])};
                gestorAplicacion.usuario.Cuenta.getCuentasList().put(datos[0], aux);
            } while (line != null);
        } catch (IOException e) {
            System.out.println("error de lectura de archivo");// Por revisar y codificar
        }

    }

}
