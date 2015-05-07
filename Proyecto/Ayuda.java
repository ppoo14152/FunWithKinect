import greenfoot.*;

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends Menu
{
   private int tipo;
    private int ban;  
   public Ayuda(String ayuda){
    super(new Pantalla(ayuda),new Mira(0,0,1));
    menu.add(new Boton(500,400,2));
                             }
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
     * Metodo botonP, en este metodo se retorna el tipo de boton que se ha presionado.
     * @return tipo Variable entera que indica el tipo de boton prsionado.
     */ 
    public int botonP(){
        return tipo;
    }
}
