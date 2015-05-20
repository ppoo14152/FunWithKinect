import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

abstract class Menu extends KinectFun 
{
    // protected boolean banInsercion;
    protected int tipo;
    public  Menu(Pantalla P, Mira M){
        super(P,M);
        // banInsercion=false;
        tipo=0;
    }

    abstract int botonP();

    public boolean perder()
    {
        return(false);
    }

    public boolean ganar()
    {
        return(false);
    }

}
