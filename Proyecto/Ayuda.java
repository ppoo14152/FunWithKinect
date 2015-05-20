import greenfoot.*;

/**
 * clase ayuda, genera un menu con opciones para ver las ayudas de los juegos
 * se iniciaizan algunas variables en la super clase , ya que estas s e heredan
 */
public class Ayuda extends Menu
{

    public Ayuda(String ayuda){
        super(new Pantalla(ayuda),new Mira(0,0,1));
        menu.add(new Boton(500,400,2));
    }

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
