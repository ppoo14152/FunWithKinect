import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Esta clase crea un esenario de tpo juegoGoool.
 */

// ban variable que sirve para añadir al mundo los objetos una sola vez.
// banPatear variable que indica cuando se ha pateado el balon.
// banBalonMueve variable que indica que el balon esta en movimiento.
// tipo variable para indicar el boton presionado.
// pieDer variable que representa la coordenada en y del pie derecho.
// pieIz variable que representa la coordenada en y del pie izquierdo.
// perder variable que indica cuando se ha perdido.
// port variable que genera la porteria.
// balon variable que genera los balones.
// portero variable que genera al portero.

public class JuegoGool extends Juego
{
    LinkedList<Boton> menu=new LinkedList<Boton>(); 
    private int tiempo;
    private long seg;

    private boolean banPatear;
    private boolean banBalonMueve;
    private int tipo;
    private int pieDer;
    private  int pieIz;   
    private Porteria port;
    private Balon balon;
    private Portero portero;
    private Label etiqueta; 

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

        banPatear=false;
        banBalonMueve=false;
        tipo=0;
        tiempo=30;
        seg=System.currentTimeMillis();       
        etiqueta=new Label("Tiempo: "+Integer.toString(tiempo),40);
    }

    /**
     * Metodo act, en este metodo se añade el balon el portero la porteria y la mira para seleccionar botones y maipular
     * el balon.
     */
    public void act() 
    {  

        if (banInsercion==false){
            getWorld().addObject(p,0,0);
            getWorld().addObject(j,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(port,340,200);
            getWorld().addObject(balon,340,420);
            getWorld().addObject(portero,340,420);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            banInsercion=true;
        }                   
        if(System.currentTimeMillis()- seg>1000 && tiempo>0){
            seg=System.currentTimeMillis();
            tiempo--;
            getWorld().removeObject(etiqueta);
            etiqueta=new Label("Tiempo: "+Integer.toString(tiempo),40);
        }
        KinectWorld mundo =(KinectWorld)getWorld();

        UserData[] usuarios = mundo.getTrackedUsers();
        for(UserData i : usuarios)
        {         
            Joint pie = i.getJoint(Joint.RIGHT_FOOT);
            pieDer=pie.getY();
            if(banPatear==false){
                pie = i.getJoint(Joint.LEFT_FOOT);
                pieIz=pie.getY();
                banPatear=true;
            }

        } 

        if(pieIz-pieDer>40 && banBalonMueve==false){
            balon.patada();

            banBalonMueve=true;
        }
        else if(pieIz-pieDer<40)
            banBalonMueve=false;
        balon.setDireccion(m.getX(),m.getY()); 
        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }

        if(tiempo==0)
            ganar=true;

        perder=j.muerto();
        getWorld().addObject(etiqueta,100,420);
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