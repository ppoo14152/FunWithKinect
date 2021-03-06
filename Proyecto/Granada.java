import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 *Esta clase genera una granada en el juegoGuerra.*/
// seg       Variable que permite contar en milisegundos
// granada   Lista de imagenes de la granada
// alto      Variable que representa el alto de la imagen
// explosion Variable que indica si ha expotado
// largo     Variable que indica el largo de la imagen
// con       Contador para cambiar los sprites de la granada
// banSonido Variable que permite reproducir el sonido una sola vez cuando ha explotado
// explota   Sonido que simula explosion
// seguro    Contiene el sonido de el seguro de la granada.
// con2      Controla el cambio de disfraces y la eliminacion del objeto.

public class Granada extends Objeto
{

    private long seg;
    private LinkedList<GreenfootImage> granada;
    private int alto;
    private boolean explosion;
    private int largo;
    private int con;
    private int con2;
    private boolean banSonido;
    private GreenfootSound explota;
    private GreenfootSound seguro;
    /**
     * constructor de la granada solo recibe coordenada en x
     * inicializa las variables y llama al constructor de la superclase para inicializar algunas otras
     * @param X coordenada en x de la granada
     */

    public Granada(int X){
        super(X,440);
        con=0;
        con2=2;
        explosion=false;
        explota= new GreenfootSound("explosion.mp3");
        seguro= new GreenfootSound("seguroGranada.mp3");
        alto=50;
        banSonido=false;
        largo=40;
        seg=System.currentTimeMillis();
        granada= new LinkedList<GreenfootImage>();
        granada.add(new GreenfootImage("granada1.png"));
        granada.add(new GreenfootImage("granada2.png"));
        granada.add(new GreenfootImage("granada3.png"));
        granada.add(new GreenfootImage("granada4.png"));
        granada.add(new GreenfootImage("granada5.png"));
        granada.get(1).scale(largo,alto);
        granada.get(2).scale(150,180);
        granada.get(3).scale(180,200);
        granada.get(4).scale(210,220);
        setImage(granada.get(1));       
        setLocation(x,y);
        seguro.play();
    }

    /**
     * Metodo act este metodo hace la animacion de la granada, cambia de sprites y 
     * genera sonido de explosion, aqui tambien se elimina a la instancia de granada
     */
    public void act() 
    {
        if( System.currentTimeMillis()- seg   >=250){
            if(con<=4){

                seg=System.currentTimeMillis();
                granada.get(1).scale(largo,alto);
                largo-=5;
                alto-=5;
                y-=30;     
                setLocation(x,y);
            }
            else{
                if(banSonido==false){
                    banSonido=true;
                    explota.play();
                    explosion=true;
                }               
                setImage(granada.get(con2));      
                con2++;
            }
            con++;
        }

        if(con2==5)
            getWorld().removeObject(this);

    }   

    /**
     * Metodo getExplosion este metodo regresa la variable de explosion 
     * @return explosion variable que indica cuando ha explotado la granada
     */
    public boolean getExplosion(){
        return explosion;
    }

}
