import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 clase nivel esta clase genera una pantalla que indica el nivel que se va a jugar
 */
public class Nivel extends Menu
{
    /**
     * Act - do whatever the Nivel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long seg;

    public Nivel(String nivel) 
    {
        super(new Pantalla(nivel),new Mira(0,0,1));      
        seg=System.currentTimeMillis();
    }    

    public void act() 
    {

        if (ban==false)
        {
            getWorld().addObject(p,0,0);
            ban=true;
        }

        if(System.currentTimeMillis()-seg>5000){
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
