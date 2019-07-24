package uiMain;

import gestorAplicacion.usuario.Invitado;

public class IniciarComoInvitado extends OpcionDeMenu {

    private String titulomenu = "Iniciar como invitado";

    @Override
    public void ejecutar() {
        Main.usuarioActivo = new Invitado();
        Main.menu = Invitado.getMenu();
    }

    @Override
    public String toString() {
        return titulomenu;
    }

}
