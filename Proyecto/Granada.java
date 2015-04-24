import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 *esta clase genera una granada en el juegoGuerra
 *@param seg variable que permite contar en milisegundos
 *@param granada lista de imagenes de la granada
 *@param alto variable que representa el alto de la imagen
 *@param explosion variable que indica si ha expotado
 *@param largo variable que indica el largo de la imagen
 *@param con contador para cambiar los sprites de la granada
 *@param banSonido variable que permite reproducir el sonido una sola vez cuando ha explotado
 *@param explota sonido que simula explosion
 */
public class Granada extends Objeto
{

    private long seg;
    private LinkedList<GreenfootImage> granada;
    private int alto;
    private int explosion;
    private int largo;
    private int con;
    private int banSonido;
    private GreenfootSound explota;
   /**
    * constructor de la granada solo recibe coordenada en x
    * inicializa las variables y llama al constructor de la superclase para inicializar algunas otras
    * @param X coordenada en x de la granada
    */
    
    public Granada(int X){
        super(X,440);
        con=0;
        explosion=0;
        explota= new GreenfootSound("explosion.mp3");
        alto=50;
        banSonido=0;
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
    }
    /**
     * metodo act este metodo hace la animacion de la granada, cambia de sprites y 
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
                if(banSonido==0){
                banSonido=1;
                explota.play();
                explosion=1;
            }               
                setImage(granada.get(con-3));              
            }
            con++;
        }
         
        if(con>=8)
             getWorld().removeObject(this);
           
    }   
    /**
     * metodo getExplosion este metodo regresa la variable de explosion 
     * @return explosion variable que indica cuando ha explotado la granada
     */
    public int getExplosion(){
        return explosion;
    }

}
