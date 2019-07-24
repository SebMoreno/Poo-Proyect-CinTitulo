package gestorAplicacion.usuario;

import baseDeDatos.Data;
import static baseDeDatos.Data.readTxt;
import static baseDeDatos.Data.writeTxt;
import java.util.HashMap;
import java.util.ArrayList;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import java.util.Scanner;
import gestorAplicacion.cine.Pelicula;
import gestorAplicacion.cine.Funcion;
import gestorAplicacion.cine.Sala;
import gestorAplicacion.cine.Silla;
import gestorAplicacion.cine.Boleta;

public abstract class Usuario {//esta sera mi super clase por eso tiene todo lo que puede hacer un usuario

    private Scanner scan = new Scanner(System.in);
    private final String usuario;
    private final String rol;
    private String clave;
    private String nombre;
    private String email;
    private static HashMap<String, String[]> usersList = new HashMap<>(); // key: usuario    value: clave, rol, nombre, email
    private static MenuDeConsola menu;

    public static void RT() {
        readTxt("usuarios.txt", usersList);
    }

    protected Usuario(String usuario, String clave, String rol, String nombre, String email, boolean existe) {
        this.clave = clave;
        this.rol = rol;
        this.nombre = nombre;
        this.email = email;
        this.usuario = usuario;
        if (!existe) {
            String[] aux = {clave, rol, nombre, email};
            usersList.put(usuario, aux);
            writeTxt("usuarios.txt", usersList);
        }/*
        if (rol.equals("admin")) {

        } else if (rol.equals(rol.equals("cliente"))) {

        } else {

        }*/
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static HashMap<String, String[]> getUsersList() {
        return usersList;
    }

    //get funtions of all users.
    //get movie infomation:
    public void getGenero(Pelicula pelicula) {
        pelicula.getGenero();
    }

    public void getClasificacion(Pelicula pelicula) {
        pelicula.getClasificacion();
    }

    public void getTitulo(Pelicula pelicula) {
        pelicula.getTitulo();
    }

    public void getDuracion(Pelicula pelicula) {
        pelicula.getDuracion();
    }

    public static MenuDeConsola getMenu() {
        return menu;
    }

    public static void setMenu(MenuDeConsola menu) {
        Usuario.menu = menu;
    }

    public void getIdioma(Pelicula pelicula) {
        pelicula.getIdioma();
    }

    //get function.
    public void getSala(Funcion funcion) {
        funcion.getSala();
    }

    public void getHora(Funcion funcion) {
        funcion.getHora();
    }

    public void getSillasOcupadas(Funcion funcion) {
        funcion.getSillasOcupadas();
    }

    public void getPelicula(Funcion funcion) {
        funcion.getPelicula();
    }

    public void getIdFuncion(Funcion funcion) {
        funcion.getIdFuncion();
    }

    //get theater.
    public void getPrecio(Sala sala) {
        sala.getPrecio();
    }

    public void getTipo(Sala sala) {
        sala.getTipo();
    }

    public void getCapacidad(Sala sala) {
        sala.getCapacidad();
    }

    public void getIdSala(Sala sala) {
        sala.getIdSala();
    }

    public void getSilla(Sala sala, int x, int y) {
        sala.getSilla(x, y);
    }

    //get silla.
    public void getIncremento(Silla silla) {
        silla.getIncremento();
    }

    public void getSala(Silla silla) {
        silla.getSala();
    }

    public void getPosicion(Silla silla) {
        silla.getPosicion();
    }

    public void getIdSilla(Silla silla) {
        silla.getIdSilla();
    }

    //ticket functions.
    public void createTicket(Cuenta dueño, Funcion funcion, Silla silla) {
        Boleta nuevo = new Boleta(dueño, funcion, silla);
    }

    private void getDueño(Boleta boleta) {
        boleta.getDueño();
    }

    private void getFuncion(Boleta boleta) {
        boleta.getDueño();
    }
}
