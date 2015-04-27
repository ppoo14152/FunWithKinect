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
      public void nuevoNivel(Pantalla pa, Mira mi){
        getWorld().removeObject(p);
        getWorld().removeObject(m);
        p=pa;
        m=mi;
        
    }
    abstract int botonP();
    abstract int perder();
    abstract int ganar();
    
}
