import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**Clase BaraFuego, permite crear objetos de este tipo los cuales son usados en el juegoLaberinto.
@param bara Guarda la imagen del objeto.
@param rot  Esta variable guarda un numero que indica el angulo de la bara. 
@param seg  Variable que almacena una relacion de tiempo la cual marca la rotacion del objeto.
@param seg2 Variable que almacena una relacion de tiempo la cual marca la reproduccion de sonido fuego.
@param fuego Contiene el sonido de juego.
 */
public class BaraFuego extends Objeto
{
    private GreenfootImage bara;
    private int rot;
    private long seg;
    private long seg2;
    private GreenfootSound fuego;

    /**Constructor aqui se inicializan tadas las variables del objeto ademas se usa el metodo super que 
    inicia las coordenadas iniciales del objeto en los ejes x e y.
     */
    public BaraFuego(){
        super(572,200);
        seg=System.currentTimeMillis(); 
        seg2=System.currentTimeMillis(); 
        bara=new GreenfootImage("baraFuego.png");
        setImage(bara);
        fuego= new GreenfootSound("fuego.mp3");
        setLocation(572,200);
        rot=0;
    }

    /** Metodo act del objeto maraca las tranciciones de giro y reproduccion de sonido del objeto. */
    public void act() 
    {

        if(  System.currentTimeMillis()- seg   >= 30){   
            seg=System.currentTimeMillis(); 
            setRotation(rot);
            rot+=1;
        }
        if(  System.currentTimeMillis()- seg2   >= 1900){   
            seg2=System.currentTimeMillis(); 
            fuego.play();
        }
    }    
}
