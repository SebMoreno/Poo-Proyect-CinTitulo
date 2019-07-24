package uiMain;

import gestorAplicacion.usuario.Invitado;
//tipo de usuario no registrado 
public class IniciarComoInvitado extends OpcionDeMenu {

    private String titulomenu = "Iniciar como invitado";

    @Override
    public void ejecutar() {//metodo que lanza el menu
        Main.usuarioActivo = new Invitado();
        Main.menu = Invitado.getMenu();
    }

    @Override
    public String toString() {
        return titulomenu;
    }

}
