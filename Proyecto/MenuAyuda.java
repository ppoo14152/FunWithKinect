import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase ayuda, esta clase genera un apantalla de ayuda, en pantalla se mostrara como jugar.
 */

public class MenuAyuda extends Menu
{ 

    /**
     * Constructor de la clase, inicializa todas las variables que se usan en esta clase.
     */
    public MenuAyuda(){
        super(new Pantalla("ayuda"),new Mira(0,0,1));
        menu.add(new Boton(500,400,2));
        menu.add(new Boton(169,374,9));
        menu.add(new Boton(169,230,10));
        menu.add(new Boton(485,300,11));
        menu.add(new Boton(485,156,12));

    }

    /**
     * Metodo act, añade la mira y los botones una sola vez al mundo.
     * tambien verificaq que tipo de boton se ha presionado.
     * 
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
            banInsercion=true;
        }

        if(m.getBan()== 1){
            for(Boton b: menu)
                if(b.getTipo()!=0)
                    tipo = b.getTipo();
        }
    }    

    /**
     * Metodo botonP, en este metodo se retorna el tipo de boton que se ha presionado.
     * @return tipo Variable entera que indica el tipo de boton prsionado.
     */ 
    public int botonP(){
        return tipo;
    }

}
