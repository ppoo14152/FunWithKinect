import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Esta clase crea un queso para el juego de laberinto, crea el queso y lo anadira al mundo.
 *@param queso imagen que representa un trozo de queso.
 */
public class Quesito extends Actor
{

    private GreenfootImage queso;
    /**
     * Constructor, aqui se crea el queso y pone la imagen en pantalla 
     */
    public Quesito(){
        queso = new GreenfootImage("queso.png");
        setImage(queso);

    }

    /** 
     * Metodo act en este metodo se verifica si se a tomado el queso, si es asi se elimina y se aumentan puntos
     */
    public void act() 
    {

        if(getOneIntersectingObject(Mira.class)!=null ){
            ((Inicio)getWorld()).IncPun();
            getWorld().removeObject(this);
        }

    }    
}
