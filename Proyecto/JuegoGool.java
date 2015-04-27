import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * esta clase crea un esenario de tpo juegoGoool
 * @param ban variable que sirve para añadir al mundo los objetos una sola vez
 * @param ban2 variable que indica cuando se ha pateado el balon
 * @param ban3 variable que indica que el balon esta en movimiento
 * @param tipo variable para indicar el boton presionado
 * @param pd variable que representa la coordenada en y dle pie derecho
 * @param pi variable que representa la coordenada en y del pie izquierdo
 * @param perder variable que indica cuando se ha perdido
 * @param port variable que genera la porteria
 * @param balon variable que genera los balones
 * @param portero variable que genera al portero
 */
public class JuegoGool extends Juego
{
    LinkedList<Boton> menu=new LinkedList<Boton>(); 
    private int tiempo;
    private long seg;
    private int ban;
    private int ban2;
    private int ban3;
    private int tipo;
    private int pd;
    private  int pi;
    private int perder;
    private Porteria port;
    private Balon balon;
    private Portero portero;
    private Label b;
    private int ganar;

    /**
     * constructor de la clase, inicializa las variables que necesita la clase, llama al constructor de la superclase
     * para iniciar algunas de estas
     */

    public JuegoGool(){
        super(new Pantalla("gool"),new Jugador(50,50,100),new Mira(0,0,4));
        menu.add(new Boton(580,450,2));
        port=new Porteria(340,200);
        balon=new Balon(340,420,10);
        portero= new Portero(340,210);
        ban=0;
        ban2=0;
        ban3=0;
        tipo=0;
        tiempo=30;
        seg=System.currentTimeMillis();
        perder=0;
        ganar=0;
        b=new Label("Tiempo: "+Integer.toString(tiempo),40);
    }

    /**
     * metodo act, eneste metodo se añade el balon el portero la porteria y la mira para seleccionar botones y maipular
     * el balon
     * 
     */
    public void act() 
    {  

        if (ban==0){
            getWorld().addObject(p,0,0);
            getWorld().addObject(j,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(port,340,200);
            getWorld().addObject(balon,340,420);
            getWorld().addObject(portero,340,420);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            ban=1;
        }                   
        if(System.currentTimeMillis()- seg>1000 && tiempo>0){
        seg=System.currentTimeMillis();
        tiempo--;
        getWorld().removeObject(b);
        b=new Label("Tiempo: "+Integer.toString(tiempo),40);
        }
        KinectWorld mundo =(KinectWorld)getWorld();

        UserData[] usuarios = mundo.getTrackedUsers();
        for(UserData i : usuarios)
        {         
            Joint pie = i.getJoint(Joint.RIGHT_FOOT);
            pd=pie.getY();
            if(ban2==0){
                pie = i.getJoint(Joint.LEFT_FOOT);
                pi=pie.getY();
                ban2=1;
            }

        } 

        if(pi-pd>40 && ban3==0){
            balon.patada();

            ban3=1;
        }
        else if(pi-pd<40)
            ban3=0;
        balon.setDireccion(m.getX(),m.getY()); 
        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }
       
        if(tiempo==0)
        ganar=1;
        
        perder=j.muerto();
        getWorld().addObject(b,100,420);
    }

    /**
     * metodo botonP, regresa el tipo de boton presionado
     * @return tipo variable que indica el tipo de boton presionado
     * 
     */
    public int botonP()
    {
        return tipo;
    }

    /**
     * metodo que incrementa los puntos del jugador si es  que ha anotado gol
     * 
     */
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * metodo que regresa la variable perder cuando se ha perdido
     * @return perde variable que indica si se ha perdido el juego
     */
    public int perder()
    {
        return perder;

    }
    public int ganar()
    {
        return ganar;

    }

    /**
     * metodo que permite recuperar los puntos del jugador
     * @return getpuntos variable contiene los puntos del jugador
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }
}