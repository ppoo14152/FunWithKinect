import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Clase Municion, nos permite crear objetos tipo municion usados en el juegoGuerra.*/

// municion Contiene la imagen de la municion.
// muni     Guarda el sonido de rcoleccion de municion que se activa al recoger municion.
// seg      Contiene una referencia de tiempo que controla el chequeo de coliciones.

public class Municion extends Objeto
{
    private GreenfootImage municion;  
    private long seg;
    private GreenfootSound muni;
    /**Constructor que inicializa las variables, utiliza el constructor de la
    superclase para inicializar las coordenadas en x e y.
    @param X Indica la coordenada inicial del objeto en el eje x.
    @param Y Indica la coordenada inicial del objeto en el eje y.
     */
    public  Municion ( int X , int Y )
    {
        super(X,Y);
        seg=System.currentTimeMillis();
        municion=new GreenfootImage("municion.png");
        municion.scale(50,50);
        muni= new GreenfootSound("municion.mp3");
    }

    /**Metodo act de la clase aqui se muestra la municion y se detecta si existe una colicion.  */
    public void act() 
    {

        setLocation(x,y);
        setImage(municion);  
        if(getOneIntersectingObject(Mira.class )!=null){
            muni.play();
            ((Inicio)getWorld()).incMun();
            if( System.currentTimeMillis()-seg>500)
                getWorld().removeObject(this);  
        }
    }

}
      
