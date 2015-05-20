import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * clase principal, crea una pantalla de menu pricipal.
 * Principal no hace referencia a que sea la clase mas importante, solo es el menu principal.
 */

public class Principal extends Menu
{

    /**
     * constructor de la clase principal,inicializa la pantalla con una nueva mira,añade los botones tambien.
     * 
     */ 
    public Principal(){
        super(new Pantalla("inicio"),new Mira(0,0,1));
        menu.add(new Boton(156,169,1));
        menu.add(new Boton(156,270,3));
        menu.add(new Boton(156,370,8));  
    }

    /**
     * metodo act de la clase principal, añade los botones, y verifica si la mira esta seleccionando alguno.
     */
    public void act() 
    {
        if (banInsercion==false)
        {
            getWorld().addObject(p,0,0);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            getWorld().addObject(m,0,0);
            getWorld().addObject( new Mono(536,384) ,536,384);
            banInsercion=true;
        }

        if(m.getBan()== 1){
            for(Boton b: menu)
                if(b.getTipo()!=0)
                    tipo = b.getTipo();
        }

    }    

    /**
     * metodo botonP, este metodo regresa el tipo del boton que se a presionado para saber que instruccion ejecutar.
     * @return tipo variable entera que indica tipo de boton.
     * 
     */
    public int botonP(){
        return tipo;
    }

}
