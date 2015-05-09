import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/** Class Sombra, nos permite crear objetos Sombra usados en el juegoForest.*/
// f   Variable que contiene la imagen del objeto. 
// c   Variable que selecciona la imagen que se muestra en pantalla.
// seg Variable que contiene una referencia de tiempo la cual marca el movimiento del objeto.
// i   Variable que contiene la direccion actual del objeto.

public class Sombra extends Objeto
{  private LinkedList<GreenfootImage> f;
    private int c;
    private long seg;
    private int i;

    /**Constructor de la clase, aqui se inicializan todas las variables del objeto.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.
     */ 
    public Sombra(int X, int Y)
    {
        super(X,Y);
        f=new LinkedList <GreenfootImage> () ;
        f.add(new GreenfootImage ("sombra.png"));
        c=0;
        i=1;
        seg=System.currentTimeMillis();
    }

    /**Metodo act de la clase, muestra el objeto en pantalla, ademas realiza el movimiento del mismo. */
    public void act() 
    {
        if( System.currentTimeMillis()- seg   >=50){
            seg=System.currentTimeMillis();
            if(y > 430)
                i=-1; 
            else if(y < 410)
                i= 1;
            y+=i;
            (f.get(c)).scale(120,120);
            setImage(f.get(c));
            setLocation(x,y);
        }

    }
}
