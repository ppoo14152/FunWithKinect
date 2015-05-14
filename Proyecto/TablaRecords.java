import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
<<<<<<< .mine
Clase Tabla records, se encarga de mostrar en pantalla una tabla con los records ordenados de menor a mayor.
 */
=======
 tabla recors crea una tabla donde se mostraran los records
 */ 
//usuario variable que contiene puntos y nombre
//tabla imagen de ofndo de la tabla
//nombre etiqueta que muestra nombre en pantalla
//etiqueta que muestra puntos en pantalla
//ban bandera que permite anadir al mundo una sola vez las cosas
//c contador para anadir el numero de usuarios

>>>>>>> .r73
//usuario Llista de usuarios cada localidad contiene el nombre y los puntos de los diferentes usuarios.
//tabla   Contiene la la imagen de la tabla.
// nombre Etiqueta que muestra el nombre.
// puntos Etiqueta que muestra la puntuacion.
// ban    Bandera que controla la incersion de los objetos en el mundo.
// c      Variable usada para ordenar las etiquetas en la tabla.
public class TablaRecords extends Actor
{
<<<<<<< .mine

    private LinkedList<Usuario> usuario;
    private GreenfootImage tabla;
    private Label nombre;
    private Label puntos;
    private int ban;
    private int c;

    /**Constructor de la clase aqui se inicializan todas las variables.
    @param us Lista de todos los usuarios.*/
    public TablaRecords(LinkedList<Usuario> us)
=======
    
   private LinkedList<Usuario> usuario;
   private GreenfootImage tabla;
   private Label nombre;
   private Label puntos;
   private boolean ban;
   private int c;
   public TablaRecords(LinkedList<Usuario> us)
>>>>>>> .r73
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
<<<<<<< .mine

        if(ban==0 )
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
            ban=1;                
        }
    }    
=======
    
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
>>>>>>> .r73
}
