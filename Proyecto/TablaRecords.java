import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 tabla recors crea una tabla donde se mostraran los records
 */ 
//usuario variable que contiene puntos y nombre
//tabla imagen de ofndo de la tabla
//nombre etiqueta que muestra nombre en pantalla
//etiqueta que muestra puntos en pantalla
//ban bandera que permite anadir al mundo una sola vez las cosas
//c contador para anadir el numero de usuarios

public class TablaRecords extends Actor
{
    
   private LinkedList<Usuario> usuario;
   private GreenfootImage tabla;
   private Label nombre;
   private Label puntos;
   private boolean ban;
   private int c;
   public TablaRecords(LinkedList<Usuario> us)
    {
        usuario=new LinkedList<Usuario>();
        usuario=us;
        ban=false;
        c=0;
        tabla=new GreenfootImage("TablaRecords.png");
        
    }
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
