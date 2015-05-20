import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**Clase portero, nos permite crear objetos de tipo Portero usados en juegoGool.*/

// portero Contiene la imagen del objeto.
// seg     Contiene una relacion de tiempo la cual marca el movimiento del objeto.
// c       Variable que contiene la velocidad con la cual se mueve el objeto.

public class Portero extends Objeto
{
    private LinkedList<GreenfootImage> portero;
    private long seg;
    private int velocidad;

    /** Constructor de la clase, aqui se inicializan todas las variables.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.
     */
    public Portero(int X, int Y)
    {
        super(X,Y);
        velocidad=1;
        portero=new LinkedList <GreenfootImage> () ;
        portero.add(new GreenfootImage ("portero.png"));
        seg=System.currentTimeMillis();
        (portero.get(0)).scale(200,180);
        setImage(portero.get(0));
    }

    /**Metodo act de la clase, se realiza el movimiento del objeto y se muestra en pantalla.*/
    public void act() 
    {
        if( System.currentTimeMillis()- seg   >=50){
            seg=System.currentTimeMillis();
            if(x < 210)
                velocidad=5;
            else if(x > 470)
                velocidad=-5;
            x+=velocidad;
            setLocation(x,y);
        }

    }    
}
