import greenfoot.*; 
import java.util.*; 
/**
 * clase pantalla, crea una pantalla de juego con una imagen
 * @param fondo imagen que sera el fondo en la pantalla
 * @param ban variale que permite anadir al mundo una sola vez los elementos
 * @param x coordenada en x del fondo
 * @param y coordenada en y del fondo
 */
public class Pantalla extends Actor
{
    GreenfootImage fondo;
    private int ban;
    private int x, y;
    /**
     * constructor de la clase, resibe una cadena con el nombre del fondo para crear un nuevo fondo con ese nombre
     * inicializa todas las variables y coloca la imagen.
     * @param Fondo cadena con el nobre del fondo
     */

    public Pantalla(String Fondo){
        
        fondo= new GreenfootImage(Fondo +".png");
        ban=0;
        x=0;
        y=0;
        setImage(fondo);
    }

    /**
     * constructor de la clase que recibe el nombre del fondo y coordenadas en x y y
     * @param Fondo nombre del fondo que se creara
     * @param X coordenada en x del fondo
     * @param Y coordenada en y dle fondo
     */
    public Pantalla(String Fondo, int X, int Y ){
  
        fondo= new GreenfootImage(Fondo +".png");
        ban=1;
        x=X;
        y=Y;
        setImage(fondo);
        
   
    }

    /**
     * metodo act en este medoto se anade al mundo los elementos y se le coloca una locacion
     */
    public void act( ) 
    {

        if(ban==0){
            x=getWorld().getWidth() / 2;
            y=getWorld().getHeight()/2;
            setLocation(x,y);
            ban=1;
            setLocation(x,y);
        }
        

    }

    /**
     * este metodo solo se usa en el juegoForest, cambia la x y la y del fondo por alguna nueva 
     * para que simule movimiento en la pantalla
     */
    public void Scroll(int X,int Y)
    {
        x=X;
        y=Y;

    }
}
