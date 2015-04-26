import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * esta clase permite generar un nuevo juego de guerra en el cual se anadiran sus elementos
 * @param menu lista de botones que estan en el mundo
 * @param arma arma del jugador tiene balas y granadas
 * @param ban variable que permite anadir al mundo los elementos solo una vez
 * @param tipo tipo de boton preisonado
 * @param perder variable que indica que ha perdido
 * @param seg variable que permite contar el tiempo en milisegundos
 * @param seg1 variable que permite contar el tiempo en milisegundos segundo contador
 * @param seg2 variable que permite contar el tiempo en milisegundos tercer contador
 * @param banA variable que permite detectar coliciones entre los elementos del juego
 */

public class JuegoGuerra extends Juego
{
    private LinkedList<Boton> menu;
    private Arma arma;        
    private int ban; 
    private int conEnem;
    private int tipo;
    private int perder;
    //private int cM;        
    private long seg, seg1,seg2;
    private Actor banA;
    private int cantEnem;
    /**
     * constructor de la clase inicializa las variables que se usan tambien inicializa algunas en el constructor de la
     * superclase
     */
    public JuegoGuerra(){
        super(new Pantalla("guerra"),new Jugador(50,50,100),new Mira(0,0,2));
        arma= new Arma(50,50);
        conEnem=0;
        menu=new LinkedList<Boton>(); 
        menu.add(new Boton(580,450,2));
        ban=0;
        tipo=0;
        perder=0;
        cantEnem=1;
        //cM=0;
        seg=System.currentTimeMillis();
        seg1=System.currentTimeMillis();
        seg2=System.currentTimeMillis();
    }

    /**
     * metodo act, anade al mundo los elementos una sola vez y algunos otros cada cierto tiempo
     */
    public void act() 
    {  
        int x;
        int rem=0;
        x=Greenfoot.getRandomNumber(600);
        if (ban==0){
            getWorld().addObject(p,0,0);
            getWorld().addObject(j,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(arma,0,0);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            ban=1;
        }                   

        if(System.currentTimeMillis()- seg > 5000){
            for(int c=0;c<cantEnem;c++){Enemigo e = new Enemigo(x,200,Greenfoot.getRandomNumber(2));
                seg = System.currentTimeMillis();
                getWorld().addObject(e,x,0);
                conEnem++;

            }
            if(conEnem>=15)
                cantEnem++;
            }

        if(System.currentTimeMillis()- seg1 > 10000){
            seg1 = System.currentTimeMillis();
            Municion mun = new Municion(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
            getWorld().addObject(mun,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));

        }

        banA=arma.getCol();  
        if(banA!=null )
            j.daña(); 

        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }
        perder=j.muerto();
    }

    /**
     * metodo botonP regresa el tipo del boon presionado
     * @return tipo variable con el tipo de boton presionado
     */
    public int botonP()
    {
        return tipo;
    }

    /**
     * metodo incPun este metodo incrementa los puntos del jugador
     */
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * metodo incMuni este metodo incrementa la municion del arma del jugador
     */
    public void incMuni(){
        arma.incBalas(10);
    }

    /**
     * metodo perder este metodo regresa una varible que indica si ha perdido o no
     * @return perder variable que indica si se ha perdido o no
     */
    public int perder()
    {
        return perder;

    }

    /**
     * metodo getPuntos este metodo regresa los puntos del jugador
     * @return puntos varibale con los puntos del jugador
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }

    /**
     * este metodo regresa un abandera de tipo entero que indica cuando ha explotado
     * una granada en el juego
     * @return explosion variable que indica explosion de una granada
     * 
     */
    public int getExplosion(){
        return arma.getExplosion();
    }
}