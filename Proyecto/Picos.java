import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**Clase Picos, nos permite crear objetos Pico usados en el juegoLaberinto.*/

// pico  Contiene los diferentes disfraces del objeto.
// seg   Variable que contiene una referencia de tiempo que maraca las transiciones entre disfraces.
// c     Esta variable indica el disfraz que se esta usando.
// filo  Contiene el sonido de activacion de la trampa.

public class Picos extends Objeto
{
    private LinkedList <GreenfootImage> pico;
    private long seg;
    private int disfraz;
    GreenfootSound filo;

    /**Constructor de la clase aqui se inicializan todas las variables del objeto , utiliza el metodo super el cual 
    inicializa las coordenadas iniciales del objeto en el eje x e y.
     */
    public Picos(){
        super(260,288);
        disfraz=0;
        filo= new GreenfootSound("picos.mp3");
        pico= new LinkedList<GreenfootImage>();
        pico.add(new GreenfootImage("picos1.png"));
        pico.add(new GreenfootImage("picos2.png"));
        setImage(pico.get(0));
        setLocation(260,288);
        seg=System.currentTimeMillis(); 
    }

    /**Metodo act de la clase aqui se realiza la transicion de disfraces cada cierto tiempo y se reproduce el sonido de activacion. */
    public void act() 
    {
        if(  System.currentTimeMillis()- seg   >= 2000){   
            seg=System.currentTimeMillis(); 
            if(disfraz==0){
                filo.play();
                disfraz=1;
            }
            else
                disfraz=0;
            setImage(pico.get(disfraz));
        }
    }   

    /** Metodo getPicos nos permite conocer el valor del disfraz usado en el momento de su ejecucion.
    @return retorna el valor de c.*/
    public int getPicos(){
        return disfraz;
    }
}
