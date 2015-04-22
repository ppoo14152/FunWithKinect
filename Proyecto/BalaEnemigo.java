import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
Clase BalaEnemigo nos permite crear objetos BalaEnemigo usados en juegoGuerra.}
@param yf variable que guarda la posicion en y de la mira al momento de disparar. 
@param c  variable que guarda la posicion en y de el alrma a el momento de disparar, se usa como un contador. 
@param bala variable que contiene la imagen de la bala.
@param coli Bandera encargada de detectar si el objeto golpea al jugador.
 */
public class BalaEnemigo extends Objeto
{
    private int yf;
    private int c;
    private GreenfootImage bala;    
    private Actor coli;

    /** Constructor encargado de inicializar todas las variables.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.
    @param ya contiene la posicion del arma , es el limite a el que llegara la bala.
     */
    public BalaEnemigo(int X,int Y,int ya){

        super(X,Y);  
        bala = new GreenfootImage("bala.png");
        setImage(bala);
        setRotation(180);
        c=y;
        yf=ya;        
    }

    /**Metodo act de la clase, aqui se realiza el movimiento de el objeto y se muestra en pantalla.*/
    public void act() 
    {
        coli = getOneIntersectingObject(Arma.class) ;    
        if(coli!=null)
            getWorld().removeObject(this);
        if(y < yf){

            setLocation(x,y);
            y+=4;      

        }
        else
            getWorld().removeObject(this);
    }    
}

