import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Esta clase genera el menu de los juegos que podra seleccionar
 * @param ban Variable que permite añadir al mundo los botones solo una vez, no se añadene n el constructor por que causa errores.
 * 
 */
public class Juegos extends Menu
{
    private int ban;
    private int tipo;
    /**
     * constructor de la clase, inicializa los botones y banderas.
     */
    public Juegos(){
        super(new Pantalla("Juegos"),new Mira(0,0,1));
        menu.add(new Boton(565,433,2));
        menu.add(new Boton(160,160, 4 ));
        menu.add(new Boton(160,240,5));
        menu.add(new Boton(160,320,6 ));
        menu.add(new Boton(160,400,7));
        ban=0;
        tipo=0;
    }

    /**
     * metodo Act, este metodo añade al mundo los botones una sola vez con ayuda de la bandera ban, tambien verifica que boton se ha presionado.
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
                    tipo=b.getTipo(); 
        }
    }    

    /**
     * metodo botonP, este metodo regresa el tipo de boton que se ha presionado
     *@return tipo Variable que indica tipo de boton.
     */
    public int botonP(){
        return tipo;
    }

}
