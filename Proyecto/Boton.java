import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**Clase Boton nos permite crear objetos de tipo menu con los cuales el jugador podra seleccionar las diferentes opciones del juego.
@param boton guarda la imagen de el boton. 
@param tipo  selecciona la imagen que se va a utilizar. */
public class Boton extends Objeto
{
    private GreenfootImage boton;
    private int tipo;
    /** Constructor inicializa las variables de la clase, utiliza el metodo super que inicializa las coordenadas iniciales del objeto.. 
    @param X cordenada inicial de el objeto en el eje x.
    @param Y cordenada inicial de el objeto en el eje y.
    @param Tipo indica el tipo de boton que se quiere crear.*/
    public  Boton(int X, int Y,int Tipo){
        super(X,Y);
        tipo=Tipo;

        switch(tipo){

            case 1: boton= new GreenfootImage("botonJugar.png");
            break;
            case 2: boton= new GreenfootImage("botonSalir.png");
            break;
            case 3: boton= new GreenfootImage("botonAyuda.png");
            break;
            case 4: boton= new GreenfootImage("botonMundo1.png");
            break;
            case 5: boton= new GreenfootImage("botonMundo2.png");
            break;
            case 6: boton= new GreenfootImage("botonMundo3.png");
            break;
            case 7 : boton= new GreenfootImage("botonMundo5.png");
            break;
            case 8 : boton= new GreenfootImage("botonSalir.png");
            break;
        }
        x=X;
        y=Y;
    }

    /** Metodo act de la clase muestra el boton en pantalla.*/
    public void act() 
    {

        setLocation(x,y);  
        setImage(boton);

    }

    /**Metodo getTipo nos permite conocer el tipo de boton.
    @return retorna el tipo de boton.*/
    public int getTipo(){
        Actor col;
        col = getOneIntersectingObject(Mira.class);
        if(col != null)
            return tipo;
        else
            return 0;
    }
}
