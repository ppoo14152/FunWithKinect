import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *esta clase crea un queso apra el juego de laberinto, creaa el queso y lo anadira
 *al mundo
 *@param queso imagen que representa un trozo de queso
 *
 */

public class Quesito extends Actor
{

    private GreenfootImage queso;
    /**constructor crea el queso y pone la imagen en pantalla
     * 
     */
    public Quesito(){
        queso = new GreenfootImage("queso.png");
        setImage(queso);

    }

    /** 
     * metodo act en este metodo se verifica si se a tomado el queso, si es asi se elimina y se aumentan puntos
     */
    public void act() 
    {
        if(getOneIntersectingObject(Mira.class)!=null ){
            ((Inicio)getWorld()).IncPun();
            getWorld().removeObject(this);
        }

    }    
}
