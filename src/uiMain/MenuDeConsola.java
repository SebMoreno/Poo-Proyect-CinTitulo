package uiMain;
import java.util.ArrayList;

public abstract class MenuDeConsola 
{
   public abstract void ejecutar ();//clase abstracta de todos los menus 
   static ArrayList <OpcionDeMenu> opciones = new ArrayList <> ();
   
   public static void Añadir_opcion(OpcionDeMenu option){
       opciones.add(option);
   }
   public static void lanzarMenu(){
      for (int i=0; i<opciones.size(); i++){
          System.out.println(opciones.get(i));
      }
   }
}
