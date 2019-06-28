package uiMain;
import java.util.*;

public abstract class MenuDeConsola 
{
   public abstract void ejecutar ();//clase abstracta de todos los menus 
   ArrayList <OpcionDeMenu> opciones = new ArrayList <> ();
   
   public void Añadir_opcion(OpcionDeMenu option){
       opciones.add(option);
   }
   public void lanzarMenu(){
      for (int i=0; i<opciones.size(); i++){
          System.out.println(opciones.get(i));
      }
   }
}
