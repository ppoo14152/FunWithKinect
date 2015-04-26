import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Record here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Record extends Menu
{
    private int tipo;
    private int ban; 
    
    private ScoreBoard puntuacion;
    public Record()
    {
        super(new Pantalla("record"),new Mira(0,0,1));
        menu.add(new Boton(567,430,2));
      
        ban=0;
        tipo=0;
    }
    
    public void act() 
    {
      if (ban==0)
     {
         getWorld().addObject(p,0,0);
         puntuacion=new ScoreBoard(329,199);
         for(Boton b : menu){
               getWorld().addObject(b,0,0);
                           }
         getWorld().addObject(m,0,0);  
         ban=1;
         getWorld().addObject(puntuacion,329,199);
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
