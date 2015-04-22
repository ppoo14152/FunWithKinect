import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameOver extends Menu
{
   private int ban;
   private int tipo;
    
    public GameOver(){
                super(new Pantalla("perder"),new Mira(0,0,1));
                menu.add(new Boton(300,300,2));
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
                tipo = b.getTipo();
        }
    }    
    
    public int botonP(){
        return tipo;
                        }

   
}
