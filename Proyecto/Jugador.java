import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Esta clase genera el jugador para los escenarios incluye salud, puntuacon  y sonidos como variables heredadas
 * del supertipo.*/
 // puntos variable encargada de acumular los puntos del jugador.
 // objeto tipo Label nos permite visualizar los puntos en el juego.
 // objeto tipo Salud el cual nos permite visualizar la salud del jugador.
 // ban bandera que no permite insertar un objeto mas de una ves.
 // vida variable que indica la cantidad de salud que tiene el jugador.
 // pierde contiene el sonido perder, se reproduce si el jugador pierde.
 // daño contiene el sonido de daño el cual se reproduce si el jugador recibe algun daño.
 
public class Jugador extends Personaje
{
    private int puntos;
    private Label puntuacion;
    private Salud salud;
    private int ban;
    private int vida;
    private GreenfootSound pierde;
    private GreenfootSound daño;      

    /** el constructor de la clase inicializa las variables del jugaodr recibiendo parametros
     * como coordenadas x,y y salud, las coordenadas se inicializan en el constructor de l a superclase
     * @param X coordenada en x del jugador
     * @param Y coordenada en y del jugador
     * @param S salud del jugador
     */
    public Jugador( int X, int Y , int S )
    {  
        super(X,Y,S);
        vida=3;      
        puntos=0;
        pierde= new GreenfootSound("pierde.mp3");
        salud=new Salud();
        ban=0;
        puntuacion=new Label(Integer.toString(puntos),50);   
        daño= new GreenfootSound("muereJugador.mp3");
    }

    /** 
     * El metodo act solo anade los puntos y la salud al mundo.
     */
    public void act(){
        if(ban==0){
            ban=1;
            getWorld().addObject(puntuacion,50,20);
            getWorld().addObject(salud,225,20);
        }
    }

    /** 

    /**
     * este metodo incrementa los puntos del jugador recibiendo el incremento como parametro
     * @param cantidad Cantidad de puntos que se incrementaran
     */ 
    public void IncPuntos(int cantidad)
    {
        puntos+=cantidad;
        getWorld().removeObject(puntuacion);
        puntuacion=new Label(Integer.toString(puntos),50);
        ban=0;
    }

    /** 
     * El metodo daña decrementa la vida del jugador, reproduce el sonido de daño y muestra en 
     * pantalla la vida restante.
     */
    public void daña(){
        daño.play();   
        if(vida>0)                 
            vida--;
        else 
            vida=0;

        salud.baja(vida);

    }

    /** 
     * El metodo muerto indica si el jugador ha perdido y  reproduce el sonido de perder.
     * @return retorna 0  si el jugador no a perdido o 1 si el jugador ha perdido. 
     */
    public int muerto()
    {
        if(vida==0){           
            pierde.play();
            return 1;
        }
        else
            return 0;
    }

    /**
     *este metodo recupera los puntos del jugador para despues crear los records
     *@return puntos puntos que tiene el jugador
     */
    public int getPuntos(){
        return puntos;
    }

}
