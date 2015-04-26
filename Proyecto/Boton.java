import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
/**Clase Boton nos permite crear objetos de tipo menu con los cuales el jugador podra seleccionar las diferentes opciones del juego.
@param boton guarda la imagen de el boton. 
@param tipo  selecciona la imagen que se va a utilizar. */
public class Boton extends Objeto
{
    private LinkedList<GreenfootImage> boton;
    private GreenfootSound seleccion;
    private int tipo;
    private int c;
    /** Constructor inicializa las variables de la clase, utiliza el metodo super que inicializa las coordenadas iniciales del objeto.. 
    @param X cordenada inicial de el objeto en el eje x.
    @param Y cordenada inicial de el objeto en el eje y.
    @param Tipo indica el tipo de boton que se quiere crear.*/
    public  Boton(int X, int Y,int Tipo){
        super(X,Y);
        tipo=Tipo;
        c=0;
        seleccion=new GreenfootSound("selec.wav");
        boton=new LinkedList<GreenfootImage>();
        switch(tipo){

            case 1: boton.add( new GreenfootImage("BotonJuegos.png"));
            boton.add( new GreenfootImage("BotonJuegos1.png"));
            break;
            case 2: boton.add( new GreenfootImage("botonRegreso.png"));
            boton.add( new GreenfootImage("botonRegreso.png"));
            break;
            case 3: boton.add( new GreenfootImage("BotonAyuda.png"));
            boton.add( new GreenfootImage("BotonAyuda1.png"));
            break;
            case 4: boton.add( new GreenfootImage("BotonLaberinto.png"));
            boton.add( new GreenfootImage("BotonLaberinto1.png"));
            break;
            case 5: boton.add( new GreenfootImage("BotonForest.png"));
            boton.add( new GreenfootImage("BotonForest1.png"));
            break;
            case 6: boton.add( new GreenfootImage("BotonGool.png"));
            boton.add( new GreenfootImage("BotonGool1.png"));
            break;
            case 7 : boton.add(new GreenfootImage("BotonGuerra.png"));
            boton.add(new GreenfootImage("BotonGuerra1.png"));
            break; 
            case 8 : boton.add( new GreenfootImage("BotonRecords.png"));
            boton.add( new GreenfootImage("BotonRecords1.png"));
            break;
        }
        x=X;
        y=Y;
    }

    /** Metodo act de la clase muestra el boton en pantalla.*/
    public void act() 
    {
        Actor coli;
        setLocation(x,y); 

        if(tipo!=2){
            boton.get(0).scale(250,70);
            boton.get(1).scale(250,70);
        }
        else{
            boton.get(0).scale(100,50);
            boton.get(1).scale(100,50);
        }
        coli = getOneIntersectingObject(Mira.class);
        if(coli != null){
            if(c==0)
            seleccion.play();
            c=1;
        }
        else
            c=0;
        setImage(boton.get(c));

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
