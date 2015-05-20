import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Esta clase crea un enemigo para el escenario de guerra habra dos tipos de enemigos.*/

// enemigo Se encarga de guardar los distintos disfraces del enemigo.
// seg     Se encarga de almacenar una referencia de tiempo para realizar los movimientos del personaje.
// dir     Indica en que direccion se mueve el enemigo.
// banDis  Indica si el jugador realizo un disparo.
// banMunicion    Indica si el jugador recogio municion.
// bala    Objeto que representa una bala enemiga, si la banDis es 1 se crea un objeto de este tipo.
// disparo Almacena el sonido de disparo de el enemigo.
// muere   Almacena el sonido de muere del enemigo.

public class Enemigo extends Objeto
{
    private LinkedList< GreenfootImage> enemigo;
    private long seg;
    private int dir;
    private int banDis;
    private boolean banMunicion;
    private BalaEnemigo bala;
    private GreenfootSound disparo;
    private GreenfootSound muere;

    /**El constructor inicializa todas las variables y recibe coordenadas x,y y el tipo de enemigo
     * aqui se llama al constructor de la superclase para inicializar las coordenadas.
     * @param X posicion inicial en el eje x del enemigo.
     * @param Y posicion inicial en el eje y del enemigo.
     * @param tipo indica el tipo de enemigo que se quiere crear.
     */
    public Enemigo(int X, int Y, int tipo){
        super(X,Y);
        disparo= new GreenfootSound("disparoEnemigo.mp3");
        muere= new GreenfootSound("muereEnemigo.mp3");
        dir=0;
        banDis=0;
        banMunicion=false;
        seg=System.currentTimeMillis();
        enemigo= new LinkedList<GreenfootImage>();

        switch(tipo){
            case 0: enemigo.add(new GreenfootImage("soldado1.png"));
            enemigo.add(new GreenfootImage("soldado1-muere.png"));
            break;
            case 1:  enemigo.add(new GreenfootImage("soldado2.png"));
            enemigo.add(new GreenfootImage("soldado2muere.png"));
            break;
        }

        setLocation(x,y);
        enemigo.get(0).scale(80,150);  
        enemigo.get(1).scale(120,120);  
        setImage(enemigo.get(0));

    }

    /**El act de esta clase hace que el ennemigo camine, si es que debe caminar,
     * tambien detecta cuando el enemigo muere y genera los puntos para el jugador
     */ 
    public void act() 
    {
        if( x >= getWorld().getWidth())
            dir= -50;
        else if( x <= 70) 
            dir= 50;
        if(getOneIntersectingObject(Bala.class)!=null ){
            setImage(enemigo.get(1));
            muere.play();
            banMunicion=true;  

        }
        if((getObjectsInRange(300,Granada.class).size()!=0)&& (((Inicio)getWorld()).explota()==true)){
            setImage(enemigo.get(1));
            muere.play();
            banMunicion=true;
        }
        if(  System.currentTimeMillis()- seg   >= 500){          
            if(banDis == 3){
                this.Dispara(x,y,400);
                banDis=0;
            }
            else
                banDis++;   

            if(banMunicion==true){
                ((Inicio)getWorld()).IncPun();
                getWorld().removeObject(this);
            }
            else{  
                seg=System.currentTimeMillis();      
                x+=dir;                
                setLocation(x,y); 

            }
        }

    }

    /**Este metodo genera una nueva bala de tipo BalaEnemigo con las coordenadas del enemigo 
     * se reproduce un sonido y se la añade al mundo.
     */
    public void Dispara(int x, int y, int yf){
        disparo.play();
        bala=new BalaEnemigo(x,y,yf);
        getWorld().addObject(bala,x,y);
    }

}