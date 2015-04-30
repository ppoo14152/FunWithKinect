import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario extends Actor
{
    private int puntos;
    private String nombre;
    
    /**
     * Act - do whatever the Usuario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     nombre="";
     puntos=0;
    }    
    public void setNombre(String n){
        nombre=n;
    }
    public void setPuntos(int p){
        puntos=p;
    }
    public String getNombre(){
        return nombre;
    }
    public int getPuntos(){
        return puntos;
    }
}
