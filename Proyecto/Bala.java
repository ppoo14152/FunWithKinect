import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
Clase Bala nos permite crear objetos de tipo Bala.
@param yf variable que guarda la posicion en y de la mira al momento de disparar. 
@param c  variable que guarda la posicion en y de el alrma a el momento de disparar, se usa como un contador. 
@param bala variable que contiene la imagen de la bala.
@param disparo variable que contiene el sonido de disparo.
 */
public class Bala extends Objeto
{

    private int yf;
    private int c;
    private GreenfootImage bala;
    private GreenfootSound disparo;
    /** Constructor de la clase Bala iniciasliza todas la variables
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.
    @param ym contiene la posicion de la mira, es el limite a el que llegara la bala.*/
    public Bala(int X,int Y,int ym ){
        super(X,Y);
        disparo= new GreenfootSound("disparo.mp3");
        bala = new GreenfootImage("bala.png");
        setImage(bala);
        yf=ym; 
        c=y;
        disparo.play();
    }

    /** Metodo act de la clase Bala, realiza el movimieto de la bala y remuebe el objeto si se llega al limite*/
    public void act() 
    {  

        if(y > yf){
            setLocation(x,y);
            y=y-c/100;
            c++;

        }
        else
            getWorld().removeObject(this);

    }    
}
