package uiMain;

public abstract class OpcionDeMenu extends MenuDeConsola{
        private String descripcion;
	public abstract void ejecutar ();//clase abstracta de todos los menus
	
	
        @Override
	public abstract String toString ();//ya que esto me ayudara a imprimir lo que hare con el objeto
	//Es necesario crear constructor con lo que hará el toString para imprimir por pantalla
        
        //Codigo toString y constructor
        /* OpcionX(String description){
            this.descripcion=description;
        }
            toString{
                System.out.println(descripcion);
        }
        */

            
	
	}
	
	
	

