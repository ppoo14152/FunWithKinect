import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
 *La clase objeto es la clase que contiene los diferentes objetos usados en el juego, asi como las variables comunes que heredan.
 */
// x variable que contiene la coordenada en el eje x del objeto.
// y variable que contiene la coordenada en el eje y del objeto.


public class Objeto extends Actor
{
    protected int x;
    protected int y;

    /** Constructor de la clase objeto recibe como parametro la coordenada en X y Y y se las asigna a las variables del objeto  */
    public Objeto(int X, int Y)
    {
        x=X;
        y=Y;
    }

}