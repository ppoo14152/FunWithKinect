import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * clase Ganar, esta clase crea una pantalla de ganar para todos los juegos
 */  
public class Ganar extends Menu
{

    private Label puntos;
    /**
     * constructor de la clase, se inicializan todas las variables que se ocupan
     */
    public Ganar(int p){
        super(new Pantalla("ganar"),new Mira(0,0,1));
        puntos= new Label(Integer.toString(p),60);
        menu.add(new Boton(567,430,2));

    }

    /**
     * metodo Act, este metodo añade una sola vez los botones y la mira, tambien verifica el tipo de boton presionado.
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
            getWorld().addObject(puntos,320,260);
            banInsercion=true;
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

