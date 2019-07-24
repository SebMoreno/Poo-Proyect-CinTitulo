package uiMain;
import gestorAplicacion.cine.Boleta;
import gestorAplicacion.cine.Silla;
import java.util.*;
import gestorAplicacion.cine.Sala;

public class ComprarBoleta extends OpcionDeMenu {
    private String titulomenu;
    private String titulopelicula;
    private ArrayList<String> funciones = new ArrayList<String>();
    private ArrayList<String> peliculas = new ArrayList<String>();
    public ComprarBoleta(String s){
        this.titulopelicula = s;
        
    }
    
    public void ejecutar(){
        /*String sala = gestorAplicacion.cine.Pelicula.getPelisList().get(titulopelicula)[4];
        String precio = gestorAplicacion.cine.Sala.getSalasList().get(sala) [0];
        System.out.println("El precio de la pelicula es "+precio);
        String nombre =uiMain.IniciarSesion.getUsuarioActivo();
        String saldouser= gestorAplicacion.usuario.Cuenta.getCuentasList().get(nombre) [0];
        int precioentero = Integer.parseInt(precio);
        int saldouserentero = Integer.parseInt(saldouser);
        
        if (precioentero > saldouserentero){
            System.out.println("saldo insuficiente");
            
        }
        
        else{
           System.out.println("Escoja silla"); 
           
           
           
        }*/
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escoja una pelicula");
        int j =0;
        for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Pelicula.getPelisList().entrySet()) {
                System.out.println("            " +(j+1) +entry.getKey() + "          ");
                j++;
                peliculas.add(entry.getKey());
        }
        int numero=entrada.nextInt();
        String pelicula=peliculas.get(numero-1);
        System.out.println("Seleccione el numero de la funcion deseada");
        int i = 0;
        for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Funcion.getFuncionesList().entrySet()) {
            if ( (entry.getValue()[1]).equals(pelicula)){
                funciones.add(entry.getKey());
                System.out.println("            " + (i+1)+entry.getKey() + "          ");
                System.out.println("Sala: " + entry.getValue()[0] + "         " + "Titulo pelicula: " + entry.getValue()[1]);
                System.out.println("Hora: " + entry.getValue()[2] + "           " + "Sillas ocupadas: " + entry.getValue()[3]);
                i++;
                funciones.add(entry.getKey());
            }}
        int numero2=entrada.nextInt();
        String funcion= funciones.get(numero2-1);
        
        String sala= gestorAplicacion.cine.Funcion.getFuncionesList().get(funcion)[0];
        String []info_sala = gestorAplicacion.cine.Sala.getSalasList().get(sala);
        //String arreglo = gestorAplicacion.cine.Sala.getSalasList().get(sala)[5];//aqui me perdi 
        String matriz[][] = new String [10][10];
        int c = 0;
        int f = 0;
        for (int index=5; index<info_sala.length; index++){
            matriz[f][c]=info_sala[index];
            c++;
            if (c>9){
                c=0;
                f++;
            }
        }
        System.out.println("Seleccione una silla disponible, escriba la identificación de la silla ");
        System.out.println(matriz);
        String silla = entrada.next();
        String user = IniciarSesion.getUsuarioActivo();
        int precio_sala = Integer.valueOf(gestorAplicacion.cine.Sala.getSalasList().get(sala)[0]);
        int precio_silla = Integer.valueOf(gestorAplicacion.cine.Silla.getSillasList().get(silla)[0]);
        int precio_total = precio_sala+precio_silla;
        String [] value_boleta = {user,funcion,silla,Integer.toString(precio_total)};
        String idBoleta = "";
        String [] value = new String [gestorAplicacion.usuario.Cuenta.getCuentasList().get(user).length+1];
        for(Map.Entry<String, String[]> entry : gestorAplicacion.cine.Boleta.getBoletasList().entrySet()){
            String [] aux = entry.getValue();
            if (aux.equals(value_boleta)){
                idBoleta = entry.getKey();
                value = entry.getValue();
            }
        }
        int new_saldo = Integer.valueOf(gestorAplicacion.usuario.Cuenta.getCuentasList().get(user)[0]) - precio_total;
        value[0] = Integer.toString(new_saldo);
        value[gestorAplicacion.usuario.Cuenta.getCuentasList().get(user).length] = idBoleta;
        gestorAplicacion.usuario.Cuenta.getCuentasList().put(user,value);
    }
    
    
    public String toString(){
        return titulomenu;
    }
}
