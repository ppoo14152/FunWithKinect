import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * clase principal, crea una pantalla de menu pricipal.
 * Principal no hace referencia a que sea la clase mas importante, solo es el menu principal.
 * @param ban Bandera para añadir al mundo los botones, no se añaden en el conrtructor por que causa errores
 * @param tipo Tipo de boton que se ha de presionar.
 */

public class Principal extends Menu
{
    private int ban;
    private int tipo;
    /**
     * constructor de la clase principal,inicializa la pantalla con una nueva mira,añade los botones tambien.
     * 
     */ 
    public Principal(){
        super(new Pantalla("inicio"),new Mira(0,0,1));
        menu.add(new Boton(200,250,1));
        menu.add(new Boton(500,250,3));
        menu.add(new Boton(350,345,8));
        ban=0;
        tipo=0;
    }

    /**
     * metodo act de la clase principal, añade los botones, y verifica si la mira esta seleccionando alguno.
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
     * metodo botonP, este metodo regresa el tipo del boton que se a presionado para saber que instruccion ejecutar.
     * @return tipo variable entera que indica tipo de boton.
     * 
     */
    public int botonP(){
        return tipo;
    }

}
