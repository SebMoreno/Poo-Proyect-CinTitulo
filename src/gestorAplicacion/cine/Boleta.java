package gestorAplicacion.cine;

import gestorAplicacion.usuario.Cuenta;
import java.util.HashMap;

public class Boleta {

    private final Cuenta dueño;
    private final Funcion funcion;
    private String estado;
    private final static HashMap<String, HashMap<String, Integer[]>> boletasList = new HashMap<>(); // key: usuario, value: idFuncion, estado

    static {
        
    }

    protected Boleta(Cuenta dueño, Funcion funcion) {
        this(dueño, funcion, "No_pagada");
    }

    protected Boleta(Cuenta dueño, Funcion funcion, String estado) {
        baseDeDatos.Registro r = new baseDeDatos.RegistroBoletas();
        this.dueño = dueño;
        this.funcion = funcion;
        this.estado = estado;
        r.readTxt();
    }

    public static void nuevaBoletasList(Integer id) {
        baseDeDatos.RegistroBoletas.nuevoFichero("b" + Integer.toString(id) + ".txt");
        //baseDeDatos.RegistroBoletas.readTxt();
    }

    public Cuenta getDueño() {
        return dueño;

    }

    public Funcion getFuncion() {
        return funcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
