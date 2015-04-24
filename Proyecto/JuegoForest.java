import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * clase JuegoForest esta clase permite crear un juego de forest
 * @param ban variable que permite anadir al mundo los elementos una sola vez
 * @param perder variable que indica si ha perdido o no
 * @param c variable cntador permite cambiar la posicion de la pantalla para simular scroll
 * @param o variable que permite poner cada cierto tiempo algunos elementos en el mundo
 * @param seg variable que permite contar en milisegundos el tiempo
 * @param seg1 variable que permite contar el tiempo en milisegundos contador 2
 * @param forest variable tipo Mono que representa el jugador en pantalla
 * @param sombra variable que representa el enmigo en pantalla
 */
public class JuegoForest extends Juego
{
    private int ban;
    private int tipo;
    private int perder;
    private int c;
    private int o;
    private long seg;
    private long seg1;
    private Mono forest;
    private Sombra sombra;
    /**
     * constructor de la clase inicializa las variables tambien inicializa algunas en el constructor de la superclas
     * 
     */
    public JuegoForest()
    {

        super(new Pantalla("Forest",640,240),new Jugador(50,50,100),new Mira(0,0, 4 ));
        forest= new Mono(240,420);
        sombra= new Sombra(50,420);
        menu.add(new Boton(580,450,2));
        ban=0;
        c=640;
        o=0;
        seg=System.currentTimeMillis();
        seg1=System.currentTimeMillis();
        perder=0;
    }

    /**
     * metodo act en este metodo se generan varios elementos del juego cada cierto tiempo y se anaden al munddo
     * tambien se genera el scroll de la pantalla
     */
    public void act() 
    {
        Random r=new Random();
        if(ban==0){
            getWorld().addObject(j,0,0);
            getWorld().addObject(p,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(forest,240,440);
            getWorld().addObject(sombra,50,440);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            ban=1;

        }

        if(  System.currentTimeMillis()- seg   >= 100){          
            seg=System.currentTimeMillis();
            if(c==0)
                c=640;
            else
                c-=2;
            p.Scroll(c,240);
            if(o==25){
                if(  System.currentTimeMillis()- seg1   >= 5000){          
                    seg1=System.currentTimeMillis();
                    getWorld().addObject(new Monstruo(640,372),640,372);
                }
                else{
                    if(r.nextFloat() > .5f)
                        getWorld().addObject(new Obstaculo(640,450,"carro",18),640,450);
                    else
                        getWorld().addObject(new Obstaculo(640,450,"bote",18),640,450);
                }
                o=0;}
            else
                o++;

        }

        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }
        perder=j.muerto();
    }

    /**
     * metodo botonP este metodo regresa el tipo de boton presonado
     * @return tipo tipo de boton que se ha presionado
     * 
     */
    public int botonP(){
        return tipo;
    }

    /**
     * metodo incPun este metodo aumenta los puntos del jugador
     */
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * metodo daña este metodo reduce la cantidad de vida actual el jugador
     */
    public void daña()
    {
        j.daña();
    }

    /**
     * metodo retrocede este metodo hace que el enemigo retroceda en pantalla
     */
    public void retrocede(){
        forest.retrocede();
    }

    /**
     * metodo perder este metodo indica cuando ha perdido o no
     * @return perder variable que indica cuando se ha perdido o no
     */
    public int perder()
    {
        return perder;
    }

    /**
     * metodo getPuntos este metodo regresa los puntos del jugador
     * @return puntos variable que contiene los puntos del jugador
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }
}
