import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/** Clase Arma, nos permite crear objetos Arma los cuales son usados en juegoGuerra.
 * */
// banRecarga      Bandera que indica si se disparo.
// banCam   Bandera que indica si el jugador camino y reproduce el sonido camina.
// granada  Objeto de tipo granada se inserta al juntar los brazos.
// banInsercion       Variable que no permite que el objeto se incerte mas de una vez en el mundo.
// x2       Variable que contiene la posicion en el eje x de el Arma.
// banMuere Bandera que indica si el jugador recibio un impacto de bala enemiga.
// balas    Variable que almacena el numero de balas que tiene el jugador.
// bala     Objeto que se inserta en el mundo cada que se realiza un disparo.
// mira     Objeto usado para apuntar a el enemigo y fijar la direccion de la bala.
// arma     Variable que contiene los diferentes disfraces de objeto.
// b        Objeto que muestra el numero de balas en pantalla.
// seg      Variable que contiene una referencia de tiempo que marca las transiciones entre los distintos disfraces.
// camina   Variable que contiene el sonido de camina el cual se reproduce cuando el jugador se mueve de un lado a otro.
// segGra   Referencia de tiempo que controla el chequeo de granadas.
// granadas Contiene el numero de granadas con las que cuenta el jugador.
// banGra   Bandera que indica si se arrojo una granada.

public class Arma extends Objeto
{      
    private  Granada granada;
    private boolean banCam;
    private boolean banMuere;
    private boolean banRecarga ;
    private boolean banGra;
    private boolean banInsercion;
    private int x2;    
    private int balas;
    private Bala bala;
    private Mira mira;
    private  LinkedList <GreenfootImage> arma;
    private Label b;
    private long seg;
    private long segG;    
    private int granadas;
    private GreenfootSound camina;

    /**Constructor de la clase, aqui se inicializan las variables del objeto.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.   
     */
    public Arma(int X,int Y){
        super(X,Y);
        banRecarga =true;
        banGra=false;
        granadas=5;
        segG=System.currentTimeMillis(); 
        banCam=false;
        camina=new GreenfootSound("caminasoldado.mp3");
        x2=0;
        banMuere=false;
        seg=System.currentTimeMillis();     
        banInsercion=false;         
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

        if(banInsercion==false){
            getWorld().addObject(mira,0,0);
            banInsercion=true;               
        }
        KinectWorld mundo =(KinectWorld)getWorld();
        UserData[] usuarios = mundo.getTrackedUsers();
        if (banMuere==true){
            if(  System.currentTimeMillis()- seg   >= 350){            
                setImage(arma.get(0));
                banMuere=false;
            }}
        for(UserData i : usuarios)
        {         
            Joint manoDerecha = i.getJoint(Joint.RIGHT_HAND);
            x=manoDerecha.getX();
            y=manoDerecha.getY(); 
            setLocation(x+50,410);
            if( banCam==false)
                x2=x;
            if ((i.getJoint(Joint.RIGHT_HAND).getX()>= i.getJoint(Joint.LEFT_HAND).getX()-3) && (i.getJoint(Joint.RIGHT_HAND).getX()<= i.getJoint(Joint.LEFT_HAND).getX()+3)  && granadas > 0 && banGra==false){
                banGra=true;
                this.lanzaGranda(x);   
                segG=System.currentTimeMillis(); 
            }else if(  System.currentTimeMillis()- segG   >= 500){ 
                segG=System.currentTimeMillis(); 
                banGra=false;
            }
            if (i.getJoint(Joint.LEFT_HAND).getY() > y && banRecarga ==false && balas > 0)
            {    
                this.Disparo(x,300,y);
                banRecarga =true;
                getWorld().removeObject(b);
                b=new Label(Integer.toString(balas),20);

            }    
            else if(i.getJoint(Joint.LEFT_HAND).getY() < y && banRecarga ==true){
                banRecarga =false;}
        }
        if(getOneIntersectingObject(BalaEnemigo.class)!=null){
            banMuere=true;
            setImage(arma.get(1));          
        }
        if(x2!=x)
        {banCam=false;
            camina.play();
        }
        getWorld().removeObject(b);
        getWorld().addObject(b,x+40,340);

    }

    /**
     * metodo lanzaGranada este metodo crea una nueva granada y la anade el mundo
     * decremetna tambien el numero de granadas del jugador
     */
    public void lanzaGranda(int x){
        granada = new Granada(x-100);
        getWorld().addObject(granada,x-100,440);
        granadas --;
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

    /**
     * metodo getExplosion este metodo regresa una bandera que indica
     * si la granada ha explotado
     */
    public boolean getExplosion(){
        return granada.getExplosion();
    }

}