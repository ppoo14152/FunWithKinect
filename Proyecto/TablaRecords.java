import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class TablaRecords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
