package uiMain;
import java.util.ArrayList;

public class MenuDeConsola {
   ArrayList <OpcionDeMenu> opciones = new ArrayList <> ();
   MenuDeConsola(ArrayList <OpcionDeMenu> options){
       this.opciones = options;
   }
   
   public void Añadir_opcion(OpcionDeMenu option){
       opciones.add(option);
   }
   public void lanzarMenu(){
      for (int i=0; i<opciones.size(); i++){
          System.out.println((i+1) + " " + opciones.get(i));
      }
   }
}
