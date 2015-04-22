import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/** Clase Arma, nos permite crear objetos Arma los cuales son usados en juegoGuerra.
 * @param ban Bandera que indica si se disparo.
 * @param banCam Bandera que indica si el jugador camino y reproduce el sonido camina.
 * @param c Variable que no permite que el objeto se incerte mas de una vez en el mundo.
 * @param x2 Variable que contiene la posicion en el eje x de el Arma.
 * @param banMuere Bandera que indica si el jugador recibio un impacto de bala enemiga.
 * @param banBal 
 * @param balas Variable que almacena el numero de balas que tiene el jugador.
 * @param bala  Objeto que se inserta en el mundo cada que se realiza un disparo.
 * @param mira  Objeto usado para apuntar a el enemigo y fijar la direccion de la bala.
 * @param arma Variable que contiene los diferentes disfraces de objeto.
 * @param b    Objeto que muestra el numero de balas en pantalla.
 * @param seg  Variable que contiene una referencia de tiempo que marca las transiciones entre los distintos disfraces.
 * @param camina Variable que contiene el sonido de camina el cual se reproduce cuando el jugador se mueve de un lado a otro.
 */
public class Arma extends Objeto
{   
    private int ban;
    private int banCam;
    private int c;
    private int x2;
    private int banMuere;
    private int banBal;
    private int balas;
    private Bala bala;
    private Mira mira;
    private  LinkedList <GreenfootImage> arma;
    private Label b;
    private long seg;
    private GreenfootSound camina;

    /**Constructor de la clase, aqui se inicializan las variables del objeto.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.   
     */
    public Arma(int X,int Y){
        super(X,Y);
        ban=1;
        banCam=0;
        camina=new GreenfootSound("caminasoldado.mp3");
        banBal=0;
        x2=0;
        banMuere=0;
        seg=System.currentTimeMillis();     
        c=0;         
        arma= new LinkedList <GreenfootImage>(); 
        arma.add(new GreenfootImage("pistola.png"));
        arma.add(new GreenfootImage("pistola2.png"));
        mira=new Mira(0,0,2);
        setImage(arma.get(0)); 
        balas = 10;
        b=new Label(Integer.toString(balas),20);           
    }

    /**Metodo act de la clase, se realiza el movimiento de la mira y se muestra en pantalla, se detecta si el jugador a realizado un disparo y
    se detecta el daño y la municion.*/
    public void act(){

        if(c==0){
            getWorld().addObject(mira,0,0);
            c=1;               
        }
        /* if(banBal==1){                        

        if((getWorld().getObjects(Bala.class)).size()==0);               
        banBal=0;
        } */
        KinectWorld mundo =(KinectWorld)getWorld();
        UserData[] usuarios = mundo.getTrackedUsers();
        if (banMuere==1){
            if(  System.currentTimeMillis()- seg   >= 350){            
                setImage(arma.get(0));
                banMuere=0;
            }}
        for(UserData i : usuarios)
        {         
            Joint manoDerecha = i.getJoint(Joint.RIGHT_HAND);
            x=manoDerecha.getX();
            y=manoDerecha.getY(); 
            setLocation(x+50,410);
            if( banCam==0)
                x2=x;
            if (i.getJoint(Joint.LEFT_HAND).getY() > y && ban==0 && balas > 0)
            {    
                this.Disparo(x,300,y);
                ban=1;
                getWorld().removeObject(b);
                b=new Label(Integer.toString(balas),20);
                banBal=1;
            }    
            else if(i.getJoint(Joint.LEFT_HAND).getY() < y && ban==1){
                ban=0;
                banBal=0;}
        }
        if(getOneIntersectingObject(BalaEnemigo.class)!=null){
            banMuere=1;
            setImage(arma.get(1));          
        }
        if(x2!=x)
        {banCam=0;
            camina.play();
        }
        getWorld().removeObject(b);
        getWorld().addObject(b,x+40,340);

    }

    /**Metodo Disparo, crea un objeto Bala y lo agrega al mundo.
    @param x indica la posicion inicial de la bala en el eje x.
    @param y indica la posicion inicial de la bala en el eje y.
    @param alto indica el limite al cual llegara la bala.
     */
    public void Disparo(int x , int y , int alto) 
    { 
        bala= new Bala(x,y,alto);
        getWorld().addObject(bala,x,y);
        balas--;

    } 

    /**Metodo incBalas, incrementa la cantidad de balas del jugador y actualiza en pantalla.
     * @param cantidad Indica el numero de balas que se incrementara.
     */
    public void incBalas(int cantidad){
        balas+=cantidad;
        getWorld().removeObject(b);
        b=new Label(Integer.toString(balas),20);
    }

    /** Metodo getCol Indica si se recibio un impacto.
    @return null si no coliciono y diferente de null si coliciono.
     */ 
    public Actor getCol(){
        return  getOneIntersectingObject(BalaEnemigo.class); 
    }

}