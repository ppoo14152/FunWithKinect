import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/** Superclase  de los diferentes escenarios del juego, contiene las clases  abstractas de los escenarios.
@param p Contiene la imagen de fondo de el escenario.
@param m Variable clase Mira almacena el apuntador usado en el escenario.
@param menu Lista que contiene los diferentes botones usados en el escenario.*/
abstract class KinectFun extends Actor
{

    public Pantalla p;
    public Mira m;
    public LinkedList<Boton> menu=new LinkedList<Boton>(); 

    /**Constructor de la clase recibe una pantalla y una mira y la inicializa. */
    public KinectFun(Pantalla P, Mira M  ){
        p=P;
        m=M;
    }

    /** Metodo nuevoNivel usado en juegoLaberinto crea una nueva pantalla y una mira y remueve los anteriores*/
    public void nuevoNivel(Pantalla pa, Mira mi){
        getWorld().removeObject(p);
        getWorld().removeObject(m);
        p=pa;
        m=mi;

    }

    /**Metodo abstracto se define en las subclases.*/
    abstract int botonP();

    /**Metodo abstracto se define en las subclases.*/
    abstract boolean perder();

    /**Metodo abstracto se define en las subclases.*/
    abstract boolean ganar();

}
