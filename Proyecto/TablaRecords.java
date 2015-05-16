import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
Clase Tabla records, se encarga de mostrar en pantalla una tabla con los records ordenados de menor a mayor.
 */
//usuario Llista de usuarios cada localidad contiene el nombre y los puntos de los diferentes usuarios.
//tabla   Contiene la la imagen de la tabla.
// nombre Etiqueta que muestra el nombre.
// puntos Etiqueta que muestra la puntuacion.
// ban    Bandera que controla la incersion de los objetos en el mundo.
// c      Variable usada para ordenar las etiquetas en la tabla.
public class TablaRecords extends Actor
{

   private LinkedList<Usuario> usuario;
   private GreenfootImage tabla;
   private Label nombre;
   private Label puntos;
   private boolean ban;
   private int c;
    /**Constructor de la clase aqui se inicializan todas las variables.
    @param us Lista de todos los usuarios.*/
    public TablaRecords(LinkedList<Usuario> us)
    {
        usuario=new LinkedList<Usuario>();
        usuario=us;
        ban=false;
        c=0;
        tabla=new GreenfootImage("TablaRecords.png");

    }

    /**Metodo act de la clase aqui se inserta la tabla y las etiquetas en orden.*/
    public void act() 
    {
    
     if(ban==false )
    {
     setLocation(getWorld().getWidth()/2,getWorld().getHeight()/2);
     tabla.scale(350,300);
     setImage(tabla);
     for(Usuario i : usuario){
       nombre=new Label(i.getNombre()+".",30);
       puntos=new Label(i.getPuntos()+".",30);
       getWorld().addObject(nombre, 231,176+40*c);
       getWorld().addObject(puntos, 432,176+40*c);
       c++;
                            }
       ban=true;                
                        }
   }    
}
