import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Clase Porteria, nos permite crear objetos Porteria usados en juegoGool*/

// porteria Variable que contiene la imagen del objeto.        

public class Porteria extends Objeto
{
    private GreenfootImage porteria;
    /**Constructor de la clase aqui se inicializan todas las variables, ademas de mostrarse en pantalla*/
    public  Porteria ( int X , int Y )
    {
        super(X,Y);
        porteria=new GreenfootImage("porteria.png");
        porteria.scale(400,200);
        setLocation(x,y);
        setImage(porteria);

    }

    /**Metodo act de la clase vacio por default.*/
    public void act() 
    {
    }
}
