import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Esta clase crea un esenario de tpo juegoGoool.
 * @param ban variable que sirve para añadir al mundo los objetos una sola vez.
 * @param ban2 variable que indica cuando se ha pateado el balon.
 * @param ban3 variable que indica que el balon esta en movimiento.
 * @param tipo variable para indicar el boton presionado.
 * @param pd variable que representa la coordenada en y del pie derecho.
 * @param pi variable que representa la coordenada en y del pie izquierdo.
 * @param perder variable que indica cuando se ha perdido.
 * @param port variable que genera la porteria.
 * @param balon variable que genera los balones.
 * @param portero variable que genera al portero.
 */
public class JuegoGool extends Juego
{
    LinkedList<Boton> menu=new LinkedList<Boton>(); 
    private int tiempo;
    private long seg;
    private boolean ban;
    private boolean ban2;
    private boolean ban3;
    private int tipo;
    private int pd;
    private  int pi;   
    private Porteria port;
    private Balon balon;
    private Portero portero;
    private Label b; 

    /**
     * Constructor de la clase, inicializa las variables que necesita la clase, llama al constructor de la superclase
     * para iniciar algunas de estas.
     */

    public JuegoGool(){
        super(new Pantalla("gool"),new Jugador(50,50,100),new Mira(0,0,4));
        menu.add(new Boton(580,450,2));
        port=new Porteria(340,200);
        balon=new Balon(340,420,10);
        portero= new Portero(340,210);
        ban=false;
        ban2=false;
        ban3=false;
        tipo=0;
        tiempo=30;
        seg=System.currentTimeMillis();       
        b=new Label("Tiempo: "+Integer.toString(tiempo),40);
    }

    /**
     * Metodo act, en este metodo se añade el balon el portero la porteria y la mira para seleccionar botones y maipular
     * el balon.
     */
    public void act() 
    {  

        if (ban==false){
            getWorld().addObject(p,0,0);
            getWorld().addObject(j,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(port,340,200);
            getWorld().addObject(balon,340,420);
            getWorld().addObject(portero,340,420);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            ban=true;
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
            if(ban2==false){
                pie = i.getJoint(Joint.LEFT_FOOT);
                pi=pie.getY();
                ban2=true;
            }

        } 

        if(pi-pd>40 && ban3==false){
            balon.patada();

            ban3=true;
        }
        else if(pi-pd<40)
            ban3=false;
        balon.setDireccion(m.getX(),m.getY()); 
        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }
       
        if(tiempo==0)
        ganar=true;
        
        perder=j.muerto();
        getWorld().addObject(b,100,420);
    }

    /**
     * Metodo botonP, regresa el tipo de boton presionado.
     * @return tipo variable que indica el tipo de boton presionado.
     * 
     */
    public int botonP()
    {
        return tipo;
    }

    /**
     * Metodo que incrementa los puntos del jugador si es  que ha anotado gol.
     * 
     */
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * Metodo que regresa la variable perder cuando se ha perdido
     * @return perde variable que indica si se ha perdido el juego.
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
     * metodo que permite recuperar los puntos del jugador
     * @return getpuntos variable contiene los puntos del jugador
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }
}