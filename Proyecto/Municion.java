import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Clase Municion, nos permite crear objetos tipo municion usados en el juegoGuerra.
@param c Bandera que detecta si se esta tocando un objeto de tipo Mira.
@param municion Contiene la imagen de la municion.
@param muni Guarda el sonido de rcoleccion de municion que se activa al recoger municion.
 */
public class Municion extends Objeto
{
    private GreenfootImage municion;
    private Actor c;
    private GreenfootSound muni;
    /**Constructor que inicializa las variables, utiliza el constructor de la
    superclase para inicializar las coordenadas en x e y.
    @param X Indica la coordenada inicial del objeto en el eje x.
    @param Y Indica la coordenada inicial del objeto en el eje y.
     */
    public  Municion ( int X , int Y )
    {
        super(X,Y);
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
            getWorld().removeObject(this);  
        }
    }

            
}

      
    
