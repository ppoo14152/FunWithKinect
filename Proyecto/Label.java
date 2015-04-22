import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**Esta clase nos permite incertar algun texto en el juego*/

public class Label extends Actor
{
    /**Constructor, que recibe una cadena la cual sera mostrada como una imagen en el juego */
    public Label(String text)
    {
        setText(text);
    }

    /**Constructor, recibe una cadena y el tamaño de la misma */
    public Label(String text, int size)
    {
        setText(text, size);
    }

    /** Metodo, recibe una cadena la cual sera mostrada como una imagen de Greenfoot */
    public void setText(String text)
    {
        setText(text,50);
    }

    /**Metodo, recibe una cadena y el tamaño de la misma */
    public void setText(String text, int size)
    {   
        setImage(new GreenfootImage(text, size, java.awt.Color.BLUE, new java.awt.Color(0,0,0,0)));
    }

    /**Metodo act de la classe */
    public void act() 
    {
     }  

}
