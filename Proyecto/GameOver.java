import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * clase GameOver, esta clase crea una pantalla de game over para todos los juegos
 * @param ban Variable que permite añadir al mundo los botones.
 * @param tipo Variable entera que indica el tipo de boton que se ha presionado.
 */

public class GameOver extends Menu
{
    private int ban;
    private int tipo;
    /**
     * constructor de la clase, se inicializan todas las variables que se ocupan
     */
    public GameOver(){
        super(new Pantalla("perder"),new Mira(0,0,1));
        menu.add(new Boton(300,300,2));
        ban=0;
        tipo=0;
    }

    /**
     * metodo Act, este metodo añade una sola vez los botones y la mira, tambien verifica el tipo de boton presionado.
     *
     */
    public void act() 
    {
        if (ban==0)
        {
            getWorld().addObject(p,0,0);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            getWorld().addObject(m,0,0);  
            ban=1;
        }

        if(m.getBan()== 1){
            for(Boton b: menu)
                if(b.getTipo()!=0)
                    tipo = b.getTipo();
        }
    }    

    /**
     * Metodo botonP, este metodo retorna el tipo de boton presionado.
     * @return tipo Variable entera que indica el tipo del boton presionado.
     */ 
    public int botonP(){
        return tipo;
    }

}
