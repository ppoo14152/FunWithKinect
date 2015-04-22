import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Juegos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juegos extends Menu
{
   private int ban;
   private int tipo;
    
    public Juegos(){
                super(new Pantalla("inicio2"),new Mira(0,0,1));
                menu.add(new Boton(550,450,2));
                menu.add(new Boton(121,113, 4 ));
                menu.add(new Boton(121,338,5));
                menu.add(new Boton(397,122,6 ));
                menu.add(new Boton(397,338,7));
                ban=0;
                tipo=0;
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
                tipo=b.getTipo(); 
        }
    }    
    
    public int botonP(){
        return tipo;
                        }
  
}
