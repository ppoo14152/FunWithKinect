import greenfoot.*; 
import java.util.*; 
public class Pantalla extends Actor
{
   GreenfootImage fondo;
   private int ban;
   private int x, y;
   
    public Pantalla(String Fondo){
           fondo= new GreenfootImage(Fondo +".png");
           ban=0;
           x=0;
           y=0;
           setImage(fondo);
                                 }
    public Pantalla(String Fondo, int X, int Y ){
           fondo= new GreenfootImage(Fondo +".png");
           ban=1;
           x=X;
           y=Y;
           setImage(fondo);
                                 }
                         
    public void act( ) 
{
            
            if(ban==0){
            x=getWorld().getWidth() / 2;
            y=getWorld().getHeight()/2;
            setLocation(x,y);
            ban=1;
                       }
            setLocation(x,y);

               
        }
    public void Scroll(int X,int Y)
    {
        x=X;
        y=Y;
       
     
    }
                                
}
