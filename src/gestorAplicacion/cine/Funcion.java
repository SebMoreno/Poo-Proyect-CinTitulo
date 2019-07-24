package gestorAplicacion.cine;

import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;
import java.util.HashMap;
import java.util.Map;

public class Funcion {

    private Sala sala;
    private Pelicula pelicula;
    private String hora;
    private Short sillasOcupadas;
    private final int idFuncion;
    private final static HashMap<String, String[]> funcionesList = new HashMap<>(); // key: idFuncion     value: idSala, tituloPelicula, hora, sillasOcupadas

    public static void RT() {
        readTxt("funciones.txt", funcionesList);
    }

    public Funcion(String idFuncion) {//Constructor para crear objetos que ya estan en los Txt
        sala = new Sala(funcionesList.get(idFuncion)[0]);
        pelicula = new Pelicula(funcionesList.get(idFuncion)[1]);
        hora = funcionesList.get(idFuncion)[2];
        sillasOcupadas = Short.valueOf(funcionesList.get(idFuncion)[3]);
        this.idFuncion = Integer.valueOf(idFuncion);

    }

    public Funcion(Sala sala, String hora, Pelicula pelicula) {
        this.sala = sala;
        this.hora = hora;
        this.pelicula = pelicula;
        int mayorId = 0, aux;
        for (Map.Entry<String, String[]> entry : funcionesList.entrySet()) {
            aux = Integer.valueOf(entry.getKey());
            if (mayorId < aux) {
                mayorId = aux;
            }
        }
        this.idFuncion = mayorId + 1;
        String[] valor = {Integer.toString(sala.getIdSala()), pelicula.getTitulo(), hora, "0"};
        funcionesList.put(Integer.toString(idFuncion), valor);
        writeTxt("funciones.txt", funcionesList);
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Short getSillasOcupadas() {
        return sillasOcupadas;
    }

    public void setSillasOcupadas(Short sillasOcupadas) {
        this.sillasOcupadas = sillasOcupadas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public static HashMap<String, String[]> getFuncionesList() {
        return funcionesList;
    }

    public static void deleteFuncion(int id) {
        if (funcionesList.containsKey(id)) {
            funcionesList.remove(id);
            System.out.println("La función ha sido eliminada exitosamente.");
        } else {
            System.out.println("No se ha enconrado ninguna fuinción\nNo se han realizado cambios.");
        }
    }

}
