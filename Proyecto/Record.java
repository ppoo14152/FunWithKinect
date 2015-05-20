import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * clase record esta clsae genera la pantalla de los records
 */
public class Record extends Menu
{

    public Record()
    {
        super(new Pantalla("record"),new Mira(0,0,1));
        menu.add(new Boton(567,430,2)); 
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

    public int botonP(){
        return tipo;
    }

}
