import greenfoot.*; 
import java.util.*; 

/**
 * Clase pantalla, crea una pantalla de juego con una imagen
 */
// fondo imagen que sera el fondo en la pantalla
// banInsercion variale que permite anadir al mundo una sola vez los elementos
// x coordenada en x del fondo
// y coordenada en y del fondo

public class Pantalla extends Actor
{
    GreenfootImage fondo;
    private boolean banInsercion;
    private int x, y;
    /**
     * Constructor de la clase, resibe una cadena con el nombre del fondo para crear un nuevo fondo con ese nombre
     * inicializa todas las variables y coloca la imagen.
     * @param Fondo cadena con el nobre del fondo
     */

    public Pantalla(String Fondo){

        fondo= new GreenfootImage(Fondo +".png");
        banInsercion=false;
        x=0;
        y=0;
        setImage(fondo);
    }

    /**
     * Constructor de la clase que recibe el nombre del fondo y coordenadas en x y y
     * @param Fondo nombre del fondo que se creara
     * @param X coordenada en x del fondo
     * @param Y coordenada en y dle fondo
     */
    public Pantalla(String Fondo, int X, int Y ){

        fondo= new GreenfootImage(Fondo +".png");
        banInsercion=true;
        x=X;
        y=Y;
        setImage(fondo);

    }

    /**
     * Metodo act en este medoto se anade al mundo los elementos y se le coloca una locacion
     */
    public void act( ) 
    {

        if(banInsercion==false){
            x=getWorld().getWidth() / 2;
            y=getWorld().getHeight()/2;
            setLocation(x,y);
            banInsercion=true;
            setLocation(x,y);
        }

    }

    /**
     * Este metodo solo se usa en el juegoForest, cambia la x y la y del fondo por alguna nueva 
     * para que simule movimiento en la pantalla
     */
    public void Scroll(int X,int Y)
    {
        x=X;
        y=Y;

    }
}
