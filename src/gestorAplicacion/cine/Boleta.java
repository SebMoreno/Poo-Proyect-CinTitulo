package gestorAplicacion.cine;

import gestorAplicacion.usuario.Cuenta;

public class Boleta {

    private final Cuenta dueño;
    private final Funcion funcion;
    private String estado;

    protected Boleta(Cuenta dueño, Funcion funcion) {
        this(dueño, funcion, "No_pagada");
    }
    

    protected Boleta(Cuenta dueño, Funcion funcion, String estado) {
        this.dueño = dueño;
        this.funcion = funcion;
        this.estado = estado;
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
