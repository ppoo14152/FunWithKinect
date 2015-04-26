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

            case 1: boton= new GreenfootImage("BotonJuegos.png");
            break;
            case 2: boton= new GreenfootImage("botonRegreso.png");
            break;
            case 3: boton= new GreenfootImage("BotonAyuda.png");
            break;
            case 4: boton= new GreenfootImage("BotonLaberinto.png");
            break;
            case 5: boton= new GreenfootImage("BotonForest.png");
            break;
            case 6: boton= new GreenfootImage("BotonGool.png");
            break;
            case 7 : boton= new GreenfootImage("BotonGuerra.png");
            break;
            case 8 : boton= new GreenfootImage("BotonRecords.png");
            break;
        }
        x=X;
        y=Y;
    }

    /** Metodo act de la clase muestra el boton en pantalla.*/
    public void act() 
    {

        setLocation(x,y); 
        if(tipo!=2)
        boton.scale(250,70);
        else
        boton.scale(100,50);
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
