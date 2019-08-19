package uiMain;

//clase abstracta de donde heredan todas las opciones de menu
public abstract class OpcionDeMenu {

	public abstract void ejecutar();//clase abstracta de todos los menus


	@Override
	public abstract String toString();//ya que esto me ayudara a imprimir lo que hare con el objeto
	//Es necesario crear constructor con lo que hará el toString para imprimir por pantalla

}
	
	
	

