import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

abstract class KinectFun extends Actor
{
    
    public Pantalla p;
    public Mira m;
    public LinkedList<Boton> menu=new LinkedList<Boton>(); 
    public KinectFun(Pantalla P, Mira M  ){
         p=P;
         m=M;
                                  }   
    abstract int botonP();
    abstract int perder();
    
}
