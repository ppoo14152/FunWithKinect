import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/** Clase Mira permite crear objetos de esta clase. 
@param tipo variable que contiene el tipo de mira que se quiere crear.
@param c variable que indica la trancicion de los diferentes disfracez del puntero.
@param seg variable que contiene una referancia de tiempo en las tranciciones de la mira del  menu.
@param seg2 variable que contiene una referancia de tiempo en los movimiento de la mira en el juegoLaberinto.
@param xg variable que contiene las coordenada en x de la mano derecha y fija la direccion de la mira en juegoLaberinto.
@param yg variable que contiene las coordenada en y de la mano derecha y fija la direccion de la mira en juegoLaberinto.
@param puntero variable que contiene los diferentes disfraces de el puntero.
@param colicion variable que indica si la mira coliciono con un boton.
@param a variable que indica si la mira coliciono con un Pared y Enemigo.
@param a1 variable que indica si la mira coliciono con un Picos.
@param a2 variable que indica si la mira coliciono con un baraFuego.
@param sel1
 */
public class Mira extends Objeto
{
    private int tipo;
    private int c;
    private long seg;
    private long seg2;
    private int xg;
    private int yg;
    private LinkedList <GreenfootImage> puntero;
    private Actor colicion;
    private Actor a,a1,a2;
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
        c=0;
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
            setImage(puntero.get(c));
            break;
            case 2:
            puntero.add(new GreenfootImage("miraArma.png")); 
            break;
            case 3: 

            puntero.add(new GreenfootImage("raton2.png"));
            puntero.get(0).scale(30,20);
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
                if(c==4)                    
                    c=0;

                else
                    c++;

            }

        }
        if(tipo==1)
            setImage(puntero.get(c));
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
        if(c==4 && (colicion!= null)){
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
        a = null;
        a = getOneIntersectingObject(Enemigo.class);
        if(a != null)
            return 1;
        else
            return 0;
    }

    /** Metodo ratonMuere  detecta si el raton se encuentra sobre un algun objeto.
    @return 0 si no se encuentra  y 1  si lo esta.*/
    public int ratonMuere(){
        a = null;
        a1=null;
        a2=null;
        a = getOneIntersectingObject(Pared.class);
        a1 = getOneIntersectingObject(Picos.class);
        a2 = getOneIntersectingObject(BaraFuego.class);
        if(a!=null || a1 !=null  || ((a2!=null) && ((Inicio)getWorld()).getPicos()==1))
            return 1;
        else
            return 0;

    }
}

