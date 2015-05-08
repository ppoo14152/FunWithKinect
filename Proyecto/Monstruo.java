import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
/**Clase Monstruo permite crear objetos de tipo monstruo usados en el juegoForest.*/

// m      Contiene los disfraces del objeto.
// ban    Variable que controla que los objetos no sean incertados mas de una vez.
// seg    Contiene una referencia de tiempo la cual maraca la transicion de disfraces asi como el movimiento del objeto.
// seg2   Contiene una referencia de tiempo la cual maraca el choque con un objeto.
// c      Variable que indica el difraz usado en el momento.
// choque Contiene el sonido de choque.

public class Monstruo extends Objeto
{
    private LinkedList<GreenfootImage> m;
    private int ban;
    private long seg;
    private long seg2;
    private int c;
    private GreenfootSound choque;
    /**Constructor de la clase Monstruo inicializa todas las variables. */
    public Monstruo(int X, int Y)
    {
        super(X,Y);
        m= new  LinkedList<GreenfootImage>();
        choque=new GreenfootSound("pierdeForest.WAV");
        ban=0;
        seg=System.currentTimeMillis();
        seg2=System.currentTimeMillis();
        c=0;
    } 

    /**Metodo act de la clase, aqui se verifican las coliciones y se realiza el movimiento del objeto, ademas de actualizar las vanderas de puntos y daño.*/
    public void act() 
    {
        if(ban==0){
            m.add(new GreenfootImage("ojo.png"));
            m.add(new GreenfootImage("ojo1.png"));
            ban=1;
        }
        if(getOneIntersectingObject(Sombra.class)!=null ){
            ((Inicio)getWorld()).IncPun();    
            getWorld().removeObject(this); 
            return;     
        }
        if(getOneIntersectingObject(Mono.class)!=null ){
            if( System.currentTimeMillis()- seg2   >= 800){
                choque.play();
                ((Inicio)getWorld()).tropesar();
                seg2= System.currentTimeMillis();
                getWorld().removeObject(this); 

            }
        }
        if(System.currentTimeMillis()-seg>300){
            seg=System.currentTimeMillis();
            if(c==1)
                c=0;
            else
                c++;
            x-=50;
        }
        m.get(c).scale(30,30);
        setImage(m.get(c));
        setLocation(x,y);
    }    
}
