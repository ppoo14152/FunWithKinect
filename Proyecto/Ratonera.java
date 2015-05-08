import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
/**
 * Esta clas crea una ratonera para el juego laberinto, se crea una lisa de imagenes
  y se ponen en pantalla*/
  
 // ratonera lista de imagenes que representan la ratonera
 // sonido   este es un sonido que imita el clik de la ratonera
 // ban      bandera que controla la eliminacion del objeto.
 // seg      contiene una referencia de tiempo para el chequeo de coliciones.

public class Ratonera extends Objeto
{
    private LinkedList<GreenfootImage> ratonera;
    private GreenfootSound sonido;
    private int ban;
    private long seg;
    /**
     * Constructor de la clase, crea la lista y carga las imagenes
     * tambien pone la primera en pantalla
     */
    public Ratonera(int tipo){
        super(0,0);
        ban=0;
        sonido= new GreenfootSound("ratoneraClik.mp3");
        ratonera= new LinkedList<GreenfootImage>();
        ratonera.add(new GreenfootImage ("ratonera1.png"));
        ratonera.add(new GreenfootImage("ratonera2.png"));
        ratonera.get(0).scale(40,75);
        ratonera.get(1).scale(40,75);
        setImage(ratonera.get(0));
        seg=0;
        if(tipo==2)
            setRotation(90);
       
    }

    /**
     * Metodo act este metodo verifica si va a matar al raton sie es asi reproduce un sonido y cambia de imagen
     */
    public void act() 
    {
        if(getOneIntersectingObject(Mira.class)!=null && ban==0){
            setImage(ratonera.get(1));
            sonido.play();
            ban=1;

            seg=System.currentTimeMillis();
        }
        if(ban==1 &&  System.currentTimeMillis()-seg>200){
            seg=System.currentTimeMillis();
            getWorld().removeObject(this);
    }
}
}
