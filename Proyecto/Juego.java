import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


abstract class Juego extends KinectFun
{

public  Jugador j;
    
    public Juego(Pantalla P, Jugador J,Mira M)
    {
        super (P,M);
        j=J;
    } 
    abstract int botonP();
    abstract void IncPun();
    abstract int perder();

    
  }
