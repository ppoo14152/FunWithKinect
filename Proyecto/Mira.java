import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/** Clase Mira permite crear objetos de esta clase.*/
// tipo     Variable que contiene el tipo de mira que se quiere crear.
// disfraz        Variable que indica la trancicion de los diferentes disfracez del puntero.
// seg      Variable que contiene una referancia de tiempo en las tranciciones de la mira del  menu.
// seg2     Variable que contiene una referancia de tiempo en los movimiento de la mira en el juegoLaberinto.
// xg       Variable que contiene las coordenada en x de la mano derecha y fija la direccion de la mira en juegoLaberinto.
// yg       Variable que contiene las coordenada en y de la mano derecha y fija la direccion de la mira en juegoLaberinto.
// puntero  Variable que contiene los diferentes disfraces de el puntero.
// colicion Variable que indica si la mira coliciono con un boton.
// ColicionEne        Variable que indica si la mira coliciono con un Pared y Enemigo.
// colicionPicos       Variable que indica si la mira coliciono con un Picos.
// colicionFuego       Variable que indica si la mira coliciono con un baraFuego.
// colicionRatonera       Variable que indica si la mira coliciono con una ratonera.
// sel1     Contiene el sonido de seleccion.

public class Mira extends Objeto
{
    private int tipo;
    private int disfraz;
    private long seg;
    private long seg2;
    private int xg;
    private int yg;
    private LinkedList <GreenfootImage> puntero;
    private Actor colicion;
    private Actor colicionEne,colicionPicos,colicionFuego,colicionRatonera;
    private GreenfootSound sel1;

    /**Constructor de la clase mira, inicializa todas las variables.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.
    @param Tipo contiene el tipo de mira que se quiere crear.
     */
    public Mira(int X, int Y, int Tipo)
    {  
        super(X,Y);  
        tipo=Tipo;
        disfraz=0;
        sel1= new GreenfootSound("seleccionInicia.WAV") ;
        puntero = new LinkedList <GreenfootImage> ();
        seg=System.currentTimeMillis();
        seg2=System.currentTimeMillis();
        switch(Tipo){
            case 1:puntero.add(new GreenfootImage("seleccion.png"));
            puntero.add(new GreenfootImage("seleccion1.png"));
            puntero.add(new GreenfootImage("seleccion2.png"));
            puntero.add(new GreenfootImage("seleccion3.png"));
            puntero.add(new GreenfootImage("seleccion4.png"));
            setImage(puntero.get(disfraz));
            break;
            case 2:
            puntero.add(new GreenfootImage("miraArma.png")); 
            break;
            case 3: 

            puntero.add(new GreenfootImage("raton2.png"));
            puntero.get(0).scale(20,10);
            break;
            case 4: puntero.add(new GreenfootImage("miraEstandar.png"));
            break;
        }  
        xg=0;
        yg=0;
    }

    /** Metodo act de la clase mira desplaza la mira por la pantalla y verifica las coliciones que tiene con otros objetos */
    public void act() 
    { 
        KinectWorld mundo =(KinectWorld)getWorld();
        UserData[] usuarios = mundo.getTrackedUsers();
        for(UserData i : usuarios)
        {         
            Joint manoDerecha = i.getJoint(Joint.RIGHT_HAND);
            x=manoDerecha.getX();
            y=manoDerecha.getY();        
            if(x>(getWorld().getWidth()/2))
                x+=20;
            else
                x-=20;
            setLocation(x,y);
        }

        colicion=getOneIntersectingObject(Boton.class);

        if( colicion!= null){

            if(  System.currentTimeMillis()- seg   >=400){          
                seg=System.currentTimeMillis();
                if(disfraz==4)                    
                    disfraz=0;

                else
                    disfraz++;

            }

        }
        else
            disfraz=0;
        if(tipo==1)
            setImage(puntero.get(disfraz));
        else 
            setImage(puntero.get(0));
        if  (tipo==3){
            if(  System.currentTimeMillis()- seg2   >=250){          
                seg2=System.currentTimeMillis();                 
                xg=x;
                yg=y;
            }
            turnTowards(xg,yg);  
        }
    }

    /**Metodo getBan detecta si se preciono un boton, reproduce el sonido de play.
    @return 0 si no se preciono ningun boton y 1 si se preciono.
     */
    public int getBan(){
        if(disfraz==4 && (colicion!= null)){
            sel1.play();
            return 1;
        }    
        else
            return 0;
    }

    /** Metodo soldadoM  detecta si la mira se encuentra sobre un Enemigo.
    @return 0 si no se encuentra sobre un Enemigo y 1  si lo esta.*/
    public int SoldadoM()
    {
        colicionEne = null;
        colicionEne = getOneIntersectingObject(Enemigo.class);
        if(colicionEne != null)
            return 1;
        else
            return 0;
    }

    /** Metodo ratonMuere  detecta si el raton se encuentra sobre un algun objeto.
    @return 0 si no se encuentra  y 1  si lo esta.*/
    public int ratonMuere(){
        colicionEne = null;
        colicionPicos=null;
        colicionFuego=null;
        colicionRatonera=null;
        colicionEne = getOneIntersectingObject(Pared.class);
        colicionPicos = getOneIntersectingObject(Picos.class);
        colicionFuego = getOneIntersectingObject(BaraFuego.class);
        colicionRatonera=getOneIntersectingObject(Ratonera.class);
        if(colicionEne!=null || colicionPicos !=null  ||  colicionRatonera!= null ||(colicionFuego!=null && ((Inicio)getWorld()).getPicos()==1) )
            return 1;
        else
            return 0;

    }
}

