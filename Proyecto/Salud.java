import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
esta clase permite visualizar la vida del jugador en pantalla, es un actor ya que 
estara cambiando con el juego, estara actuando
@param salud Lista de imagenes que muestran la cantidad de salud
 */
public class Salud extends Actor
{
    private LinkedList <GreenfootImage> salud;

    /** el constructor de salud inicializa las imagenes necesarias en una lista y coloca la primer
     * imagen en pantalla
     */
    public Salud(){      
        salud=new LinkedList<GreenfootImage>();
        salud.add(new GreenfootImage("salud4.png"));
        salud.add(new GreenfootImage("salud3.png"));
        salud.add(new GreenfootImage("salud2.png"));
        salud.add(new GreenfootImage("salud1.png"));       
        setImage(salud.get(3));
        setLocation(120,10);
    }

    public void act() 
    {

    }  

    /**este metodo decrementa la salud del jugador, cambia de imagen dpendiendo de una variable.
     * @param s Varable que permite controlar y sincronizar la vida del jugador con las imagenes de vida.
     */
    public void baja(int s){    
        setImage(salud.get(s));        
    }
}
