import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Clase JuegoForest esta clase permite crear un juegoForest.
 */
//ban variable que permite anadir al mundo los elementos una sola vez
// perder variable que indica si ha perdido o no
// c variable cntador permite cambiar la posicion de la pantalla para simular scroll
// o variable que permite poner cada cierto tiempo algunos elementos en el mundo
//seg variable que permite contar en milisegundos el tiempo
// seg1 variable que permite contar el tiempo en milisegundos contador 2
// forest variable tipo Mono que representa el jugador en pantalla
//sombra variable que representa el enmigo en pantalla

public class JuegoForest extends Juego
{
    private boolean ban;
    private int tipo;
    private int c;
    private int o;
    private long seg;
    private long seg1;
    private Mono forest;
    private Sombra sombra;
    /**
     * Constructor de la clase inicializa las variables tambien inicializa algunas en el constructor de la superclase. 
     */
    public JuegoForest()
    {

        super(new Pantalla("Forest"),new Jugador(50,50,100),new Mira(0,0, 4 ));
        forest= new Mono(240,420);
        sombra= new Sombra(50,420);
        menu.add(new Boton(580,450,2));
        ban=false;
        c=640;
        o=0;
        seg=System.currentTimeMillis();
        seg1=System.currentTimeMillis();

    }

    /**
     * Metodo act en este metodo se generan varios elementos del juego cada cierto tiempo y se anaden al munddo
     * tambien se genera el scroll de la pantalla
     */
    public void act() 
    {
        Random r=new Random();
        if(ban==false){
            getWorld().addObject(j,0,0);
            getWorld().addObject(p,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(forest,240,440);
            getWorld().addObject(sombra,50,440);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            ban=true;

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
                        getWorld().addObject(new Obstaculo(640,450,"carro",20),640,450);
                    else
                        getWorld().addObject(new Obstaculo(640,450,"bote",20),640,450);
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

        if(forest.getX() > getWorld().getWidth()-50)
            ganar=true;

        perder=j.muerto();
    }

    /**
     * Metodo botonP este metodo regresa el tipo de boton presionado.
     * @return tipo tipo de boton que se ha presionado.
     * 
     */
    public int botonP(){
        return tipo;
    }

    /**
     * Metodo incPun este metodo aumenta los puntos del jugador.
     */
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * Metodo daña este metodo reduce la cantidad de vida actual el jugador.
     */
    public void daña()
    {
        j.daña();
    }

    /**
     * Metodo retrocede este metodo hace que el enemigo retroceda en pantalla.
     */
    public void retrocede(){
        forest.retrocede();
    }

    /**
     * Metodo perder este metodo indica cuando ha perdido o no.
     * @return perder variable que indica cuando se ha perdido o no.
     */
    public boolean perder()
    {
        return perder;
    }

    /**Este metodo retorna el valor de la variable ganar que indica si se a completado el juego.
    @return ganar 0 si no se ha ganado, 1 si se gano.
     */
    public boolean ganar()
    {
        return ganar;
    }

    /**
     * Metodo getPuntos este metodo regresa los puntos del jugador.
     * @return puntos variable que contiene los puntos del jugador.
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }
}
