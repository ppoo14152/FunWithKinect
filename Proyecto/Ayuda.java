import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase ayuda, esta clase genera un apantalla de ayuda, en pantalla se mostrara como jugar.
 * @param tipo Variable que indica el tipo de boton que se presiono.
 * @param ban Variable que permite añadir los botones y la mira al mundo una sola vez.

 */

public class Ayuda extends Menu
{ private int tipo;
    private int ban;  
    /**
     * constructor de la clase,inicializa todas las variables que se usan en esta clase.
     */
    public Ayuda(){
        super(new Pantalla("ayuda"),new Mira(0,0,1));
        menu.add(new Boton(500,400,2));
        ban=0;
        tipo=0;
    }

    /**
     * metodo act, añade la mira y los botones una sola vez al mundo.
     * tambien verificaq que tipo de boton se ha presionado.
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
     * metodo botonP, en este metodo se retorna el tipo de boton que se ha presionado
     * @return tipo Variable entera que indica el tipo de boton prsionado.
     */ 
    public int botonP(){
        return tipo;
    }

}
