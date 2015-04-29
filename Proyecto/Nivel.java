import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel extends Menu
{
    /**
     * Act - do whatever the Nivel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int ban;
    private int tipo;
    private long seg;

    public Nivel(String nivel) 
    {
        super(new Pantalla(nivel),new Mira(0,0,1));
        ban=0;
        tipo=0;
        seg=System.currentTimeMillis();
    }    
    
    public void act() 
    {
        if (ban==0)
        {
            getWorld().addObject(p,0,0);
            ban=1;
        }
        if(System.currentTimeMillis()-seg>3000){
        getWorld().removeObject(p);
        getWorld().removeObject(this);
    }

    }    

    /**
     * Metodo botonP, este metodo retorna el tipo de boton presionado.
     * @return tipo Variable entera que indica el tipo del boton presionado.
     */ 
    public int botonP(){
        return 0;
    }
}
