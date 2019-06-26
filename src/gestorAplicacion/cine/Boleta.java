package gestorAplicacion.cine;

import gestorAplicacion.usuario.Usuario;

public class Boleta {
    private final Usuario dueño;
    private final Funcion funcion;
    private String estado = "No pagada";

    public Boleta(Usuario dueño, Funcion funcion) {
        this.dueño = dueño;
        this.funcion = funcion;
    }

    public Boleta(Usuario dueño, Funcion funcion, String estado) {
        this.dueño = dueño;
        this.funcion = funcion;
        this.estado = estado;
    }

    public Usuario getDueño() {
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
