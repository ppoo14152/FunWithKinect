import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

    abstract class Menu extends KinectFun 
     {
    public  Menu(Pantalla P, Mira M){
        super(P,M);
                                   }
    abstract int botonP();
     public int perder()
    {
        return(0);
    }
     public int ganar()
    {
        return(0);
    }
       
}
