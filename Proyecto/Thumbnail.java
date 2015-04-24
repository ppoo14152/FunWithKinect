import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * esta clase genera una pequeña camara en pantalla
 * toma imagenes cada cierto tiempo y las actualiza en pantalla  
 */
public class Thumbnail  extends Actor
{
    public Thumbnail()
    {
    }

    /**
     * Act -en una serie de imagenes que se actualian periodicamente se guarda una fotografia del mundo exterior
     * y al actualizar simula un video
     */
    public void act() 
    {
        GreenfootImage img = ((KinectWorld)getWorld()).getThumbnailUnscaled();
        setImage(img);
    }
}
